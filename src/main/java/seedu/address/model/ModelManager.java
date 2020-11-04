package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.budget.Threshold.NO_THRESHOLD_MESSAGE;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.Page;
import seedu.address.state.PageTitle;
import seedu.address.state.State;
import seedu.address.state.StateManager;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.state.budgetindex.EmptyBudgetIndex;
import seedu.address.state.expenditureindex.ExpenditureIndex;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final Nusave nusave;
    private final UserPrefs userPrefs;
    private final FilteredList<Renderable> filteredRenderables;
    private final State state;
    private final History<BudgetList> history;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyNusave nusave, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(nusave, userPrefs);
        logger.fine("Initializing with NUSave: " + nusave + " and user prefs " + userPrefs);
        this.nusave = new Nusave(nusave);
        this.userPrefs = new UserPrefs(userPrefs);
        this.filteredRenderables = new FilteredList<>(this.nusave.getInternalList());
        this.state = new StateManager(new EmptyBudgetIndex(), Page.MAIN, PageTitle.MAIN_PAGE_TITLE);
        this.history = new HistoryManager<>(BudgetList.clone(this.nusave.getBudgetList()));
        sortBudgetsByCreatedDate();
    }
    /**
     * Initializes a new ModelManager.
     */
    public ModelManager() {
        this(new Nusave(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getNusaveFilePath() {
        return userPrefs.getNusaveFilePath();
    }

    @Override
    public void setNusavePath(Path nusaveFilePath) {
        requireNonNull(nusaveFilePath);
        userPrefs.setNusaveFilePath(nusaveFilePath);
    }

    //=========== Nusave =======

    @Override
    public void setNusave(ReadOnlyNusave nusave) {
        requireNonNull(nusave);
        this.nusave.resetData(nusave);
    }

    @Override
    public ReadOnlyNusave getNusave() {
        return nusave;
    }

    //=========== Budgets =======

    @Override
    public void openBudget(BudgetIndex budgetIndex) {
        requireNonNull(budgetIndex);
        BudgetIndex actualBudgetIndex = getActualBudgetIndex(budgetIndex);
        setBudgetIndex(actualBudgetIndex);
        setPageName(getPageName(actualBudgetIndex));
        setPage(Page.BUDGET);
        String newExpenditureValue = calculateExpenditureValue(actualBudgetIndex);
        setTotalExpenditure(newExpenditureValue);
        Optional<Threshold> newThreshold = getThreshold();
        setThreshold(newThreshold);
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        repopulateObservableList();
    }

    @Override
    public void closeBudget() {
        setBudgetIndex(new EmptyBudgetIndex());
        setPageName(PageTitle.MAIN_PAGE_TITLE);
        setPage(Page.MAIN);
        setTotalExpenditure(StateManager.defaultValueTotalExpenditure());
        setThreshold(Optional.empty());
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        repopulateObservableList();
    }

    private BudgetIndex getActualBudgetIndex(BudgetIndex budgetIndex) {
        assert budgetIndex.getBudgetIndex().isPresent();
        int indexInFilteredList = budgetIndex.getBudgetIndex().get();
        assert indexInFilteredList >= 0 && indexInFilteredList < filteredRenderables.size();
        Budget budget = (Budget) filteredRenderables.get(indexInFilteredList);
        int indexInBudgetList = nusave.getIndexOfBudget(budget);
        return new BudgetIndexManager(indexInBudgetList);
    }

    @Override
    public void addBudget(Budget budget) {
        requireNonNull(budget);
        nusave.addBudget(budget);
        saveToHistory();
    }

    @Override
    public void deleteBudget(BudgetIndex budgetIndex) {
        requireNonNull(budgetIndex);
        assert budgetIndex.getBudgetIndex().isPresent();
        int index = budgetIndex.getBudgetIndex().get();
        assert index < filteredRenderables.size();
        Budget budget = (Budget) filteredRenderables.get(index);
        nusave.deleteBudget(budget);
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        saveToHistory();
    }

    /**
     * Edit a budget from NUSave.
     * @param oldBudget the budget to be edited
     * @param editedBudget edited budget to replace the old budget
     */
    @Override
    public void editBudget(Budget oldBudget, Budget editedBudget) {
        requireAllNonNull(oldBudget, editedBudget);
        nusave.editBudget(oldBudget, editedBudget);
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        saveToHistory();
    }

    @Override
    public void deleteAllBudgets() {
        nusave.deleteAllBudgets();
        saveToHistory();
    }

    @Override
    public void findBudget(String searchTerm) throws CommandException {
        Predicate<Renderable> predicate = renderable -> renderable.contains(searchTerm);
        updateFilteredRenderableList(predicate);
        if (filteredRenderables.size() == 0) {
            throw new CommandException(String.format("No budgets matching '%s' were found.", searchTerm));
        }
    }

    @Override
    public void listBudgets() throws CommandException {
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        if (filteredRenderables.size() == 0) {
            throw new CommandException("You have no budgets recorded, try creating one with the create command!");
        }
    }

    @Override
    public void sortBudgetsByName() {
        nusave.sortBudgetListByName();
        repopulateObservableList();
    }

    @Override
    public void sortBudgetsByCreatedDate() {
        nusave.sortBudgetListByCreatedDate();
        repopulateObservableList();
    }

    //=========== Expenditures =======

    @Override
    public void deleteExpenditure(ExpenditureIndex expenditureIndex) {
        requireNonNull(expenditureIndex);
        assert expenditureIndex.getExpenditureIndex().isPresent();
        int index = expenditureIndex.getExpenditureIndex().get();
        assert index < filteredRenderables.size();
        Expenditure expenditure = (Expenditure) filteredRenderables.get(index);
        Optional<Integer> budgetIndex = state.getBudgetIndex();
        nusave.deleteExpenditure(expenditure, budgetIndex);
        setTotalExpenditure(nusave.getTotalExpenditureValue(budgetIndex));
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }

    /**
     * Adds an expenditure to the specified budget and updates the list
     * @param expenditure the expenditure to be added
     */
    @Override
    public void addExpenditure(Expenditure expenditure) {
        requireNonNull(expenditure);
        Optional<Integer> budgetIndex = this.state.getBudgetIndex();
        nusave.addExpenditure(expenditure, this.state.getBudgetIndex());
        setTotalExpenditure(nusave.getTotalExpenditureValue(budgetIndex));
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }

    @Override
    public void editExpenditure(Expenditure oldExpenditure, Expenditure editedExpenditure) {
        requireAllNonNull(oldExpenditure, editedExpenditure);
        Optional<Integer> budgetIndex = this.state.getBudgetIndex();
        nusave.editExpenditure(oldExpenditure, editedExpenditure, budgetIndex);
        setTotalExpenditure(nusave.getTotalExpenditureValue(budgetIndex));
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }

    @Override
    public void listExpenditures() throws CommandException {
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        if (filteredRenderables.size() == 0) {
            throw new CommandException("You have no expenditures recorded, try creating one with the add command!");
        }
    }

    @Override
    public void findExpenditure(String searchTerm) throws CommandException {
        Predicate<Renderable> predicate = renderable -> renderable.contains(searchTerm);
        updateFilteredRenderableList(predicate);
        if (filteredRenderables.size() == 0) {
            throw new CommandException(String.format("No expenditures matching '%s' were found.", searchTerm));
        }
    }

    @Override
    public void sortExpendituresByName() {
        nusave.sortExpendituresByName(state);
        repopulateObservableList();
    }

    @Override
    public void sortExpenditureByCreatedDate() {
        nusave.sortExpendituresByCreateDate(state);
        repopulateObservableList();
    }

    @Override
    public String calculateExpenditureValue(BudgetIndex budgetIndex) {
        Optional<Integer> indexOpt = budgetIndex.getBudgetIndex();
        return nusave.getTotalExpenditureValue(indexOpt);
    }

    //=========== ObservableList =======

    @Override
    public void repopulateObservableList() {
        nusave.repopulateObservableList(state);
    }

    //=========== StateManager ================================================================================

    @Override
    public boolean isMain() {
        return this.state.isMain();
    }

    @Override
    public boolean isBudget() {
        return this.state.isBudget();
    }

    @Override
    public boolean isWithinRange(BudgetIndex budgetIndex) {
        assert budgetIndex.getBudgetIndex().isPresent();
        int index = budgetIndex.getBudgetIndex().get();
        return index < filteredRenderables.size();
    }

    @Override
    public boolean isWithinRange(ExpenditureIndex expenditureIndex) {
        assert expenditureIndex.getExpenditureIndex().isPresent();
        int index = expenditureIndex.getExpenditureIndex().get();
        return index < filteredRenderables.size();
    }

    @Override
    public Page getPage() {
        return this.state.getPage();
    }

    @Override
    public BooleanProperty getBudgetPageProp() {
        return this.state.getIsBudgetPageProp();
    }

    @Override
    public StringProperty getTotalExpenditureStringProp() {
        return state.getInfoBoxSecondRowProp();
    }

    @Override
    public StringProperty getThresholdStringProp() {
        return state.getThresholdStringProp();
    }

    @Override
    public String getPageName(BudgetIndex index) {
        return this.nusave.getPageName(index);
    }

    @Override
    public String getPageTitle() {
        return this.state.getPageTitle();
    }

    @Override
    public String getTotalExpenditureValue() {
        Optional<Integer> budgetIndex = state.getBudgetIndex();
        assert budgetIndex.isPresent();
        return nusave.getTotalExpenditureValue(budgetIndex);
    }

    @Override
    public Optional<Threshold> getThreshold() {
        Optional<Integer> budgetIndex = state.getBudgetIndex();
        return nusave.getThreshold(budgetIndex);
    }

    @Override
    public boolean isBudgetPage() {
        return this.state.isBudgetPage();
    }

    @Override
    public void setBudgetIndex(BudgetIndex budgetIndex) {
        this.state.setBudgetIndex(budgetIndex);
    }

    public Optional<Integer> getBudgetIndex() {
        return this.state.getBudgetIndex();
    }

    @Override
    public void setPage(Page page) {
        this.state.setPage(page);
    }

    @Override
    public void setTotalExpenditure(String expenditure) {
        this.state.setTotalExpenditure(expenditure);
    }

    @Override
    public void setThreshold(Optional<Threshold> threshold) {
        if (threshold.isPresent()) {
            String thresholdStr = threshold.get().toString();
            this.state.setThresholdStringProp(thresholdStr);
        } else {
            this.state.setThresholdStringProp(NO_THRESHOLD_MESSAGE);
        }
    }

    @Override
    public void setPageName(String page) {
        this.state.setPageName(page);
    }

    //=========== Filtered Renderable List Accessors =============================================================

    @Override
    public ObservableList<Renderable> getFilteredRenderableList() {
        return filteredRenderables;
    }

    @Override
    public void updateFilteredRenderableList(Predicate<Renderable> predicate) {
        requireNonNull(predicate);
        filteredRenderables.setPredicate(predicate);
    }

    //=========== Undo Redo =============================================================

    @Override
    public boolean canUndo() {
        return history.hasHistory();
    }

    @Override
    public void undo() {
        BudgetList budgetList = history.getHistory();
        nusave.setBudgets(budgetList);
        repopulateObservableList();
    }

    @Override
    public boolean canRedo() {
        return history.hasFuture();
    }

    @Override
    public void redo() {
        BudgetList budgetList = history.getFuture();
        nusave.setBudgets(budgetList);
        repopulateObservableList();
    }

    private void saveToHistory() {
        BudgetList toSave = nusave.getBudgetList();
        BudgetList clone = BudgetList.clone(toSave);
        history.save(clone);
    }
}

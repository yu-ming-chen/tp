package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_NO_ENTRIES_FOUND;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.beans.property.BooleanProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.budget.Budget;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.Page;
import seedu.address.state.PageTitle;
import seedu.address.state.StateManager;
import seedu.address.state.budgetindex.BudgetIndex;
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
    private final StateManager stateManager;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyNusave nusave, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(nusave, userPrefs);

        logger.fine("Initializing with address book: " + nusave + " and user prefs " + userPrefs);

        this.nusave = new Nusave(nusave);
        this.userPrefs = new UserPrefs(userPrefs);
        this.filteredRenderables = new FilteredList<>(this.nusave.getInternalList());
        this.stateManager = new StateManager(new EmptyBudgetIndex(), Page.MAIN, PageTitle.MAIN_PAGE_TITLE);
    }

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
        return null;
    }

    @Override
    public void setNusavePath(Path nusaveFilePath) {

    }

    @Override
    public void setNusave(ReadOnlyNusave nusave) {

    }

    //=========== Nusave =======

    @Override
    public ReadOnlyNusave getNusave() {
        return nusave;
    }

    @Override
    public void addBudget(Budget budget) {
        requireNonNull(budget);
        nusave.addBudget(budget);
    }

    @Override
    public void deleteBudget(BudgetIndex budgetIndex) throws CommandException {
        requireNonNull(budgetIndex);
        int index = budgetIndex.getBudgetIndex().orElse(-1);
        if (filteredRenderables.size() <= index) {
            throw new CommandException(Messages.BUDGET_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        Budget budget = (Budget) filteredRenderables.get(index);
        nusave.deleteBudget(budget);
    }

    @Override
    public void deleteAllBudgets() {
        nusave.deleteAllBudgets();
    }

    @Override
    public void sortAllBudget() {
        nusave.sortBudgetList();
    }

    @Override
    public void deleteExpenditure(ExpenditureIndex expenditureIndex) throws CommandException {
        requireNonNull(expenditureIndex);
        int index = expenditureIndex.getExpenditureIndex().orElse(-1);
        if (filteredRenderables.size() <= index) {
            throw new CommandException(Messages.EXPENDITURE_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        Expenditure expenditure = (Expenditure) filteredRenderables.get(index);
        Optional<Integer> budgetIndex = stateManager.getBudgetIndex();
        nusave.deleteExpenditure(expenditure, budgetIndex);
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }

    /**
     * Adds an expenditure to the specified budget and updates the list
     * @param expenditure
     */
    public void addExpenditure(Expenditure expenditure) throws CommandException {
        requireNonNull(expenditure);
        nusave.addExpenditure(expenditure, this.stateManager.getBudgetIndex());
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }
    @Override
    public void sortExpenditure() {
        nusave.sortExpenditureList(stateManager);
    }

    @Override
    public void repopulateObservableList() throws CommandException {
        nusave.repopulateObservableList(stateManager);
        updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
    }

    //=========== StateManager ================================================================================

    @Override
    public boolean isMain() {
        return this.stateManager.isMain();
    }

    @Override
    public boolean isBudget() {
        return this.stateManager.isBudget();
    }

    @Override
    public Page getPage() {
        return this.stateManager.getPage();
    }

    @Override
    public BooleanProperty getIsExpenditureProp() {
        return this.stateManager.getIsExpenditureProp();
    }

    @Override
    public String getPageName(BudgetIndex index) {
        return this.nusave.getPageName(index);
    }

    @Override
    public String getPageTitle() {
        return this.stateManager.getPageTitle();
    }

    @Override
    public boolean isExpenditure() {
        return this.stateManager.isExpenditure();
    }

    @Override
    public void setIsExpenditurePage(boolean isExpenditurePage) {
        this.stateManager.setIsExpenditurePage(isExpenditurePage);
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        this.stateManager.setBudgetIndex(index);
    }

    @Override
    public void setPage(Page page) {
        this.stateManager.setPage(page);
    }

    @Override
    public void setPageName(String page) {
        this.stateManager.setPageName(page);
    }

    //=========== Filtered Renderable List Accessors =============================================================

    @Override
    public ObservableList<Renderable> getFilteredRenderableList() {
        return filteredRenderables;
    }

    @Override
    public void updateFilteredRenderableList(Predicate<Renderable> predicate) throws CommandException {
        requireNonNull(predicate);
        filteredRenderables.setPredicate(predicate);
        if (filteredRenderables.size() == 0) {
            throw new CommandException(MESSAGE_NO_ENTRIES_FOUND);
        }
    }
}

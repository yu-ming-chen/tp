package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.State;
import seedu.address.state.budgetindex.BudgetIndex;

public class Nusave implements ReadOnlyNusave {
    private final BudgetList budgetList;
    private final ObservableList<Renderable> internalList = FXCollections.observableArrayList();
    private final ObservableList<Renderable> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);
    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        this.budgetList = new BudgetList();
    }

    public Nusave() { }

    /**
     *
     * @param toBeCopied
     */
    public Nusave(ReadOnlyNusave toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    public String getPageName(BudgetIndex index) {
        return this.budgetList.getBudgetName(index);
    }

    private void resetData(ReadOnlyNusave newData) {
        requireNonNull(newData);

        setBudgets(newData.getBudgetList());
    }

    //=========== Budget ==================================================================================
    /**
     * Adds a budget to the NUSave.
     */
    public void addBudget(Budget budget) {
        this.budgetList.add(budget);
        this.internalList.add(budget);
    }

    /**
     * Deletes a budget from NUSave.
     */
    public void deleteBudget(Budget toRemove) {
        this.budgetList.remove(toRemove);
        this.internalList.remove(toRemove);
    }

    /**
     * Edit a budget from NUSave.
     * @param oldBudget the budget to be edited
     * @param editedBudget edited budget to replace the old budget
     */
    public void editBudget(Budget oldBudget, Budget editedBudget) {
        int index = budgetList.getIndexOfBudget(oldBudget);
        this.budgetList.editBudget(oldBudget, editedBudget);
        this.internalList.set(index, editedBudget);
    }

    private void setBudgets(List<Budget> budgets) {
        this.budgetList.setBudgets(budgets);
        this.internalList.setAll(budgets);
    }

    public void deleteAllBudgets() {
        setBudgets(new ArrayList<>());
    }

    public int getIndexOfBudget(Budget budget) {
        return budgetList.getIndexOfBudget(budget);
    }

    //=========== Expenditure ==================================================================================
    /**
     * Adds a expenditure to the NUSave budget according to its index.
     */
    public void addExpenditure(Expenditure expenditure, Optional<Integer> budgetIndexOpt) {
        int budgetIndex = budgetIndexOpt.orElse(-1);
        assert budgetIndex >= 0;
        this.internalList.add(expenditure);
        this.budgetList.addExpenditure(expenditure, budgetIndex);
    }

    /**
     * Edits an expenditure to the NUSave budget according to its index.
     * @param oldExpenditure
     * @param editedExpenditure
     * @param budgetIndexOpt
     */
    public void editExpenditure(Expenditure oldExpenditure, Expenditure editedExpenditure,
                                Optional<Integer> budgetIndexOpt) {
        int budgetIndex = budgetIndexOpt.orElse(-1);
        assert budgetIndex >= 0;
        int expenditureIndex = this.internalList.indexOf(oldExpenditure);
        this.internalList.set(expenditureIndex, editedExpenditure);
        this.budgetList.editExpenditure(oldExpenditure, editedExpenditure, budgetIndex);
    }

    /**
     * Deletes an expenditure from the NUSave budget according to its index.
     */
    public void deleteExpenditure(Expenditure expenditure, Optional<Integer> budgetIndexOpt) {
        int budgetIndex = budgetIndexOpt.orElse(-1);
        List<Expenditure> expenditureList = budgetList.getExpenditure(budgetIndex);
        expenditureList.remove(expenditure);
        this.internalList.remove(expenditure);
    }

    //=========== ObservableList ==================================================================================
    /**
     * Sets the observable list displayed in UI based on the
     * current state.
     * @param state State containing the current page and
     *              budget index.
     */
    public void repopulateObservableList(State state) {
        if (state.isBudget()) {
            // repopulate observable list with Expenditures
            int index = state.getBudgetIndex().orElse(-1);
            assert index >= 0;
            assert index < budgetList.getSize();
            this.internalList.setAll(budgetList.getExpenditure(index));
        } else if (state.isMain()) {
            // repopulate observable list with Budgets
            this.internalList.setAll(budgetList.getBudgets());
        }
    }

    @Override
    public ObservableList<Budget> getBudgetList() {
        return budgetList.asUnmodifiableObservableList();
    }

    public ObservableList<Renderable> getInternalList() {
        return internalUnmodifiableList;
    }

    public void sortBudgetListByName() {
        budgetList.sortBudgetListByName();
    }

    public void sortBudgetListByCreatedDate() {
        this.budgetList.sortBudgetListByCreateDate();
    }

    /**
     * sort current ExpenditureList
     * @param state current state
     */
    public void sortExpendituresByName(State state) {
        int index = state.getBudgetIndex().orElse(-1);
        budgetList.getExpenditure(index).sort(new SortExpendituresByName());
    }

}

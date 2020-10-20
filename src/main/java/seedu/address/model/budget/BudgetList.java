package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.SortBudgetByCreateDate;
import seedu.address.model.SortBudgetByName;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.budgetindex.BudgetIndex;

/**
 * A list of persons that enforces uniqueness between its elements and does not allow nulls.
 * A person is considered unique by comparing using {@code Person#isSamePerson(Person)}. As such, adding and updating of
 * persons uses Person#isSamePerson(Person) for equality so as to ensure that the person being added or updated is
 * unique in terms of identity in the UniquePersonList. However, the removal of a person uses Person#equals(Object) so
 * as to ensure that the person with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 */
public class BudgetList implements Iterable<Budget> {
    private final List<Budget> budgets = new ArrayList<>();

    /**
     * Adds a budget to the list of budgets.
     */
    public void add(Budget toAdd) {
        requireNonNull(toAdd);
        budgets.add(toAdd);
    }

    /**
     * Adds an expenditure to a the budget at index index in budgets.
     * @param toAdd the Expenditure object to be added.
     * @param index the index of the budget which the expenditure will be added into.
     */
    public void addExpenditure(Expenditure toAdd, int index) {
        Budget budget = budgets.get(index);
        budget.addExpenditure(toAdd);
    }

    /**
     * Deletes an expenditure from the budget at index index in budgets.
     * @param toDelete the Expenditure object to be deleted.
     * @param index the index of the budget which the expenditure will be added into.
     */
    public void deleteExpenditure(int toDelete, int index) {
        Budget budget = budgets.get(index);
        budget.deleteExpenditure(toDelete);
    }

    /**
     * Removes the equivalent budget from the list.
     * The budget must exist in the list.
     */
    public void remove(Budget toRemove) {
        requireNonNull(toRemove);
        budgets.remove(toRemove);
    }

    public List<Expenditure> getExpenditure(int index) {
        Budget budget = budgets.get(index);
        return budget.getExpenditures();
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public String getBudgetName(BudgetIndex budgetIndex) {
        requireNonNull(budgetIndex);
        int index = budgetIndex.getBudgetIndex().orElse(-1);
        assert index >= 0;
        return this.budgets.get(index).getName().value;
    }

    public int getSize() {
        return budgets.size();
    }

    public boolean hasBudget(Budget budget) {
        return budgets.contains(budget);
    }

    /**
     * Replaces the contents of this list with {@code budgets}.
     */
    public void setBudgets(List<Budget> budgets) {
        requireAllNonNull(budgets);
        // internalList.setAll(budgets);
        this.budgets.clear();
        this.budgets.addAll(budgets);
    }

    public int getIndexOfBudget(Budget budget) {
        return this.budgets.indexOf(budget);
    }

    /**
     * Edit a budget from NUSave.
     * @param oldBudget the budget to be edited
     * @param editedBudget edited budget to replace the old budget
     */
    public void editBudget(Budget oldBudget, Budget editedBudget) {
        int index = this.budgets.indexOf(oldBudget);
        this.budgets.set(index, editedBudget);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Budget> asUnmodifiableObservableList() {
        ObservableList<Budget> internalBudgetList = FXCollections.observableArrayList();
        internalBudgetList.setAll(budgets);
        ObservableList<Budget> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalBudgetList);
        return internalUnmodifiableList;
    }

    public void sortBudgetListByName() {
        budgets.sort(new SortBudgetByName());
    }

    public void sortBudgetListByCreateDate() {
        this.budgets.sort(new SortBudgetByCreateDate());
    }

    @Override
    public Iterator<Budget> iterator() {
        return budgets.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BudgetList // instanceof handles nulls
                && budgets.equals(((BudgetList) other).budgets));
    }

    @Override
    public int hashCode() {
        return budgets.hashCode();
    }
}

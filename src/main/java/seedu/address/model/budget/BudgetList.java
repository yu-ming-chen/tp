package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.budget.exceptions.BudgetNotFoundException;
import seedu.address.model.expenditure.Expenditure;

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
    private final ObservableList<Budget> internalList = FXCollections.observableArrayList();
    private final ObservableList<Budget> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Adds a person to the list.
     * The person must not already exist in the list.
     */
    public void add(Budget toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
        budgets.add(toAdd);
    }

    public void add(Expenditure toAdd, int index) {
        budgets.get(index).addExpenditure(toAdd);
    }

    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    public void remove(Budget toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new BudgetNotFoundException();
        }
        budgets.remove(toRemove);
    }

    public List<Expenditure> getExpenditure(int index) {
        return budgets.get(index).getExpenditures();
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(BudgetList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
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

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Budget> asUnmodifiableObservableList() {
        ObservableList<Budget> internalBudgetList = FXCollections.observableArrayList();
        internalBudgetList.setAll(budgets);
        ObservableList<Budget> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalBudgetList);
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Budget> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BudgetList // instanceof handles nulls
                && internalList.equals(((BudgetList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}

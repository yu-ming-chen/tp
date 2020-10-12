package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.State;

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

    private void setBudgets(List<Budget> budgets) {
        this.budgetList.setBudgets(budgets);
        this.internalList.setAll(budgets);
    }

    private void resetData(ReadOnlyNusave newData) {
        requireNonNull(newData);

        setBudgets(newData.getBudgetList()); // todo: change to getBudgetsList()
    }

    /**
     * Adds a budget to the NUSave.
     */
    public void addBudget(Budget budget) {
        // todo: fix this
        this.budgetList.add(budget);
        this.internalList.add(budget);
    }

    /**
     * Adds a expenditure to the NUSave budget according to its index.
     */
    public void addExpenditure(Expenditure expenditure, Optional<Integer> budgetIndexOpt) {
        int budgetIndex = budgetIndexOpt.orElse(-1);
        assert budgetIndex >= 0;
        this.internalList.add(expenditure);
        this.budgetList.add(expenditure, budgetIndex);
    }

    /**
     * Sets the observable list displayed in UI based on the
     * current state.
     * @param state State containing the current page and
     *              budget index.
     */
    public void repopulateObservableList(State state) {
        if (state.isBudget()) {
            int index = state.getBudgetIndex().orElse(-1);
            assert index >= 0;
            this.internalList.setAll(budgetList.getExpenditure(index));
        } else if (state.isMain()) {
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

}

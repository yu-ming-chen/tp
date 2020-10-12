package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.expenditure.Expenditure;

public class Nusave implements ReadOnlyNusave {
    private final BudgetList budgetList;

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
    }

    /**
     * Adds a expenditure to the NUSave budget according to its index.
     */
    public void addExpenditure(Expenditure expenditure, Optional<Integer> budgetIndexOpt) {
        Integer budgetIndex = budgetIndexOpt.orElse(-1);
        assert budgetIndex >= 0;
        //this.budgetList.get(budgetIndex).addExpenditure(expenditure);
    }

    @Override
    public ObservableList<Budget> getBudgetList() {
        return budgetList.asUnmodifiableObservableList(); //todo: for UI team to fix
    }

}

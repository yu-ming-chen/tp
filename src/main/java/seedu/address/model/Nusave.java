package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;

import javax.swing.text.html.Option;

public class Nusave implements ReadOnlyNusave {
    private final List<Budget> budgets;

    public Nusave() {
        this.budgets = new ArrayList<>();
    }

    /**
     *
     * @param toBeCopied
     */
    public Nusave(ReadOnlyNusave toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    private void resetData(ReadOnlyNusave newData) {
        requireNonNull(newData);

        setBudgets(newData.getBudgets()); // todo: change to getBudgetsList()
    }

    private void setBudgets(List<Budget> budgets) {
        for (Budget budget : budgets) {
            addBudget(budget);
        }
    }

    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }

    public void deleteBudget(int budget) {
        this.budgets.remove(budget);
    }

    public void deleteExpenditure(int expenditure, Optional<Integer> budgetIndexOpt) {
        Integer budgetIndex = budgetIndexOpt.orElse(-1);
        assert budgetIndex >= 0;
        this.budgets.get(budgetIndex).deleteExpenditure(expenditure);
    }

    @Override
    public ObservableList<Budget> getBudgetList() {
        return null; //todo: for UI team to fix
    }

    @Override
    public List<Budget> getBudgets() {
        return budgets;
    }
}

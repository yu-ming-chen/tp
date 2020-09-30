package seedu.address.state.budgetindex;

import java.util.Optional;

public class BudgetIndexManager implements BudgetIndex {
    private int budgetIndex;

    public BudgetIndexManager(int budgetIndex) {
        this.budgetIndex = budgetIndex;
    }

    @Override
    public void setIndex(int index) {
        this.budgetIndex = index;
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return Optional.of(this.budgetIndex);
    }
}

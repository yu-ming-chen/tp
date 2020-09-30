package seedu.address.state.budgetindex;

import java.util.Optional;

public class EmptyBudgetIndex implements BudgetIndex {
    @Override
    public void setIndex(int index) {
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return Optional.empty();
    }
}

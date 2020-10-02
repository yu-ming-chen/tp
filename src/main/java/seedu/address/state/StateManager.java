package seedu.address.state;

import java.util.Optional;

import seedu.address.state.budgetindex.BudgetIndex;

public class StateManager implements State {
    private BudgetIndex budgetIndex;
    private Page currentPage;

    /**
     * Constructs a {@code StateManager} with the given {@code BudgetIndex} and {@code Page}.
     * @param budgetIndex current budget index NUSave is accessed in.
     * @param currentPage current page NUSave is accessed in.
     */
    public StateManager(BudgetIndex budgetIndex, Page currentPage) {
        this.budgetIndex = budgetIndex;
        this.currentPage = currentPage;
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return this.budgetIndex.getBudgetIndex();
    }

    @Override
    public Page getPage() {
        return this.currentPage;
    }

    @Override
    public boolean isMain() {
        return false;
    }

    @Override
    public boolean isBudget() {
        return false;
    }

    @Override
    public void setPage(Page page) {
        this.currentPage = page;
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        this.budgetIndex = index;
    }
}

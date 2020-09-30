package seedu.address.state;

import seedu.address.state.budgetindex.BudgetIndex;

import java.util.Optional;

public class StateManager implements State {
    BudgetIndex budgetIndex;
    Page currentPage;

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

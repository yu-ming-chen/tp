package seedu.address.state;

import java.util.Optional;

import seedu.address.state.budgetindex.BudgetIndex;

public interface State {

    Optional<Integer> getBudgetIndex();

    Page getPage();

    boolean isMain();

    boolean isBudget();

    void setPage(Page page);

    void setBudgetIndex(BudgetIndex index);
}

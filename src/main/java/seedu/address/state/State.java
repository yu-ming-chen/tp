package seedu.address.state;

import seedu.address.state.budgetindex.BudgetIndex;

import java.util.Optional;

public interface State {

    Optional<Integer> getBudgetIndex();

    Page getPage();

    boolean isMain();

    boolean isBudget();

    void setPage(Page page);

    void setBudgetIndex(BudgetIndex index);
}

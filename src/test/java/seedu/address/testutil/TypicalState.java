package seedu.address.testutil;

import seedu.address.state.Page;
import seedu.address.state.State;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.state.budgetindex.EmptyBudgetIndex;

public class TypicalState {

    public static final State TYPICAL_BUDGET_PAGE_STATE = new StateBuilder().withBudgetIndex(new BudgetIndexManager(0))
            .withCurrentPage(Page.BUDGET).withPageTitle("McDonalds").build();

    public static final State TYPICAL_MAIN_PAGE_STATE = new StateBuilder().withBudgetIndex(new EmptyBudgetIndex())
            .withCurrentPage(Page.MAIN).withPageTitle("NUSave").build();;

    private TypicalState() {} // prevents instantiation
}

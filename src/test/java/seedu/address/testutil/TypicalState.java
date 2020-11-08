package seedu.address.testutil;

import seedu.address.model.budget.Budget;
import seedu.address.state.Page;
import seedu.address.state.State;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.state.budgetindex.EmptyBudgetIndex;

public class TypicalState {

    public static final BudgetIndex MAIN_PAGE_BUDGET_INDEX = new EmptyBudgetIndex();
    public static final BudgetIndex MCDONALDS_BUDGET_INDEX = new BudgetIndexManager(0);
    public static final BudgetIndex KFC_BUDGET_INDEX = new BudgetIndexManager(1);
    public static final BudgetIndex SUBWAY_BUDGET_INDEX = new BudgetIndexManager(2);

    public static final State MCDONALDS_BUDGET_PAGE_STATE = new StateBuilder().withBudgetIndex(MCDONALDS_BUDGET_INDEX)
            .withCurrentPage(Page.BUDGET).withPageTitle("McDonalds").build();

    public static final State KFC_BUDGET_PAGE_STATE = new StateBuilder().withBudgetIndex(KFC_BUDGET_INDEX)
            .withCurrentPage(Page.BUDGET).withPageTitle("KFC").build();

    public static final State SUBWAY_BUDGET_PAGE_STATE = new StateBuilder().withBudgetIndex(SUBWAY_BUDGET_INDEX)
            .withCurrentPage(Page.BUDGET).withPageTitle("Subway").build();

    public static final State TYPICAL_MAIN_PAGE_STATE = new StateBuilder().withBudgetIndex(MAIN_PAGE_BUDGET_INDEX)
            .withCurrentPage(Page.MAIN).withPageTitle("NUSave").build();

    private TypicalState() {} // prevents instantiation

    public static State getTypicalMainPageState() {
        return new StateBuilder().withBudgetIndex(new EmptyBudgetIndex())
                .withCurrentPage(Page.MAIN).withPageTitle("NUSave").build();
    }

    public static State getMcdonaldsBudgetPageState() {
        return new StateBuilder().withBudgetIndex(new BudgetIndexManager(0))
                .withCurrentPage(Page.BUDGET).withPageTitle("McDonalds").build();
    }

    public static State getKfcBudgetPageState() {
        return new StateBuilder().withBudgetIndex(new BudgetIndexManager(1))
                .withCurrentPage(Page.BUDGET).withPageTitle("KFC").build();
    }

    public static State getSubwayBudgetPageState() {
        return new StateBuilder().withBudgetIndex(new BudgetIndexManager(2))
                .withCurrentPage(Page.BUDGET).withPageTitle("Subway").build();
    }
}

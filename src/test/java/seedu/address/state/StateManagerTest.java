package seedu.address.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;


class StateManagerTest {
    public static final BudgetIndex VALID_BUDGET_INDEX = new BudgetIndexManager(1);
    public static final Page VALID_PAGE = Page.MAIN;
    public static final String VALID_PAGE_TITLE = PageTitle.MAIN_PAGE_TITLE;
    public static final StateManager VALID_STATE_MANAGER = new StateManager(VALID_BUDGET_INDEX,
            VALID_PAGE, VALID_PAGE_TITLE);

    @Test
    void constructor_nullParameters_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StateManager(
                null, VALID_PAGE, VALID_PAGE_TITLE));
        assertThrows(NullPointerException.class, () -> new StateManager(
                VALID_BUDGET_INDEX, null, VALID_PAGE_TITLE));

        assertThrows(NullPointerException.class, () -> new StateManager(
                VALID_BUDGET_INDEX, VALID_PAGE, null));
    }

    @Test
    void isMain_currentPageMain_true() {
        assertTrue(new StateManager(VALID_BUDGET_INDEX, Page.MAIN, VALID_PAGE_TITLE).isMain());
    }

    @Test
    void isMain_currentPageBudget_false() {
        assertFalse(new StateManager(VALID_BUDGET_INDEX, Page.BUDGET, VALID_PAGE_TITLE).isMain());
    }

    @Test
    void isBudget_currentPageBudget_true() {
        assertTrue(new StateManager(VALID_BUDGET_INDEX, Page.BUDGET, VALID_PAGE_TITLE).isBudget());
    }

    @Test
    void isBudget_currentPageMain_false() {
        assertFalse(new StateManager(VALID_BUDGET_INDEX, Page.MAIN, VALID_PAGE_TITLE).isBudget());
    }

    @Test
    void setPage_nullPage_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> VALID_STATE_MANAGER.setPage(null));
    }

    @Test
    void setTotalExpenditure_nullString_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> VALID_STATE_MANAGER.setTotalExpenditure(null));
    }

    @Test
    void setBudgetIndex_nullBudgetIndex_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> VALID_STATE_MANAGER.setBudgetIndex(null));
    }

    @Test
    void setPageName_nullString_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> VALID_STATE_MANAGER.setPageTitle(null));
    }

}

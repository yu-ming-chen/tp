package seedu.address.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.state.StateManager.defaultValueTotalExpenditure;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalState.ENUM_PAGE_BUDGET;
import static seedu.address.testutil.TypicalState.ENUM_PAGE_MAIN;
import static seedu.address.testutil.TypicalState.MAIN_PAGE_BUDGET_INDEX;
import static seedu.address.testutil.TypicalState.MAIN_PAGE_TITLE;
import static seedu.address.testutil.TypicalState.MAIN_THRESHOLD_VALUE;
import static seedu.address.testutil.TypicalState.MCDONALDS_BUDGET_INDEX;
import static seedu.address.testutil.TypicalState.MCDONALDS_BUDGET_PAGE_STATE;
import static seedu.address.testutil.TypicalState.MCDONALDS_PAGE_TITLE;
import static seedu.address.testutil.TypicalState.SUBWAY_PAGE_TITLE;
import static seedu.address.testutil.TypicalState.TYPICAL_MAIN_PAGE_STATE;
import static seedu.address.testutil.TypicalState.getKfcBudgetPageState;
import static seedu.address.testutil.TypicalState.getMcdonaldsBudgetPageState;
import static seedu.address.testutil.TypicalState.getSubwayBudgetPageState;
import static seedu.address.testutil.TypicalState.getTypicalMainPageState;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;


public class StateManagerTest {
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

    @Test
    void getBudgetIndex_mainPage_success() {
        State mainPageState = getTypicalMainPageState();
        assertEquals(mainPageState.getBudgetIndex(), MAIN_PAGE_BUDGET_INDEX.getBudgetIndex());
    }

    @Test
    void getBudgetIndex_budgetPage_sucess() {
        State budgetPageState = getMcdonaldsBudgetPageState();
        assertEquals(budgetPageState.getBudgetIndex(), MCDONALDS_BUDGET_INDEX.getBudgetIndex());
    }

    @Test
    void getPage_mainPage_success() {
        State mainPageState = getTypicalMainPageState();
        assertEquals(mainPageState.getPage(), ENUM_PAGE_MAIN);
    }

    @Test
    void getPage_budgetPage_success() {
        State budgetPageState = getKfcBudgetPageState();
        assertEquals(budgetPageState.getPage(), ENUM_PAGE_BUDGET);
    }

    @Test
    void getPageTitle_mainPage_success() {
        State mainPageState = getTypicalMainPageState();
        assertEquals(mainPageState.getPageTitle(), MAIN_PAGE_TITLE);
    }

    @Test
    void getPageTitle_budgetPage_success() {
        State budgetPageState = getSubwayBudgetPageState();
        assertEquals(budgetPageState.getPageTitle(), SUBWAY_PAGE_TITLE);
    }

    @Test
    void setOpenCommandState_mainPage_success() {
        State mainPageState = getTypicalMainPageState();
        mainPageState.setBudgetIndex(MCDONALDS_BUDGET_INDEX);
        mainPageState.setOpenCommandState(MCDONALDS_PAGE_TITLE, defaultValueTotalExpenditure(),
                Optional.of(MAIN_THRESHOLD_VALUE));
        assertEquals(MCDONALDS_BUDGET_PAGE_STATE, mainPageState);
    }

    @Test
    void setOpenCommandState_budgetPage_fail() {
        State budgetPageState = getMcdonaldsBudgetPageState();
        assertThrows(AssertionError.class, () -> budgetPageState.setOpenCommandState(
                MCDONALDS_PAGE_TITLE, defaultValueTotalExpenditure(),
                Optional.of(MAIN_THRESHOLD_VALUE)
        ));
    }

    @Test
    void setCloseCommandState_mainPage_success() {
        State budgetPageState = getMcdonaldsBudgetPageState();
        budgetPageState.setCloseCommandState();
        assertEquals(budgetPageState, TYPICAL_MAIN_PAGE_STATE);
    }

    @Test
    void setCloseCommandState_budgetPage_fail() {
        State mainPageState = getTypicalMainPageState();
        assertThrows(AssertionError.class, () -> mainPageState.setCloseCommandState());
    }
}

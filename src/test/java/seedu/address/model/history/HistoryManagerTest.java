package seedu.address.model.history;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.address.model.budget.Budget;
import seedu.address.testutil.TypicalBudget;

class HistoryManagerTest {
    @Test
    void hasHistory_withoutHistory_returnsFalse() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertFalse(historyManager.hasHistory());
    }

    @Test
    void hasFuture_withoutFuture_returnsFalse() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertFalse(historyManager.hasFuture());
    }

    @Test
    void getHistory_withoutHistory_throwsAssertionError() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertThrows(AssertionError.class, () -> historyManager.getHistory());
    }

    @Test
    void getFuture_withoutHistory_throwsAssertionError() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertThrows(AssertionError.class, () -> historyManager.getFuture());
    }

    @Test
    void saveToHistory_nullParameters_throwsNullPointerException() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertThrows(NullPointerException.class, () -> historyManager.saveToHistory(null));
    }

    @Test
    void saveToFuture_nullParameters_throwsNullPointerException() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertThrows(NullPointerException.class, () -> historyManager.saveToFuture(null));
    }
    
    @Test
    void equals_sameHistoryManager_returnsTrue() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertTrue(historyManager.equals(historyManager));
    }

    @Test
    void equals_ValidHistoryManager_returnsTrue() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        historyManager.saveToHistory(TypicalBudget.getKfcBudget());
        HistoryManager<Budget> historyManagerToCompare = new HistoryManager<>();
        historyManager.saveToHistory(TypicalBudget.getKfcBudget());
        assertTrue(historyManager.equals(historyManagerToCompare));
    }

    @Test
    void equals_withNull_returnsFalse() {
        HistoryManager<Budget> historyManager = new HistoryManager<>();
        assertFalse(historyManager.equals(null));
    }
}
package seedu.address.state.budgetindex;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BudgetIndexManagerTest {
    public static final int VALID_BUDGET_INDEX = 1;
    public static final int INVALID_BUDGET_INDEX = -1;

    @Test
    void constructor_invalidInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new BudgetIndexManager(INVALID_BUDGET_INDEX));
    }

    @Test
    void setIndex_invalidInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new BudgetIndexManager(VALID_BUDGET_INDEX)
                .setIndex(INVALID_BUDGET_INDEX));
    }
}

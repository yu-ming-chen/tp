package seedu.address.state.expenditureindex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class ExpenditureIndexManagerTest {
    public static final int VALID_EXPENDITURE_INDEX = 0;
    public static final int INVALID_EXPENDITURE_INDEX = -1;

    @Test
    void constructor_invalidInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new ExpenditureIndexManager(INVALID_EXPENDITURE_INDEX));
    }

    @Test
    void setIndex_validInput() {
        ExpenditureIndex actual = new ExpenditureIndexManager(1);
        actual.setIndex(VALID_EXPENDITURE_INDEX);
        ExpenditureIndex expected = new ExpenditureIndexStub().getTypicalExpenditureIndex();
        assertEquals(expected, actual);
    }

    @Test
    void setIndex_invalidInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new ExpenditureIndexManager(VALID_EXPENDITURE_INDEX)
                .setIndex(INVALID_EXPENDITURE_INDEX));
    }

    @Test
    void getIndex() {
        ExpenditureIndex expected = new ExpenditureIndexStub().getTypicalExpenditureIndex();
        assertEquals(expected.getExpenditureIndex(), Optional.of(0));
    }

    class ExpenditureIndexStub {
        public final ExpenditureIndex getTypicalExpenditureIndex() {
            return new ExpenditureIndexManager(VALID_EXPENDITURE_INDEX);
        }
    }
}

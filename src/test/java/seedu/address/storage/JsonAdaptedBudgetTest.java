package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;

class JsonAdaptedBudgetTest {
    public static final String INVALID_NAME_BLANK = "";
    public static final String INVALID_NAME_NON_ALPHANUMERIC = "@Household Expenses";
    public static final List<JsonAdaptedExpenditure> INVALID_EXPENDITURES = new ArrayList<>();

    public static final String VALID_NAME = "Household Expenses";
    public static final List<JsonAdaptedExpenditure> VALID_EXPENDITURES = new ArrayList<>();
    /*
    Todo:
    -toModelType_invalidExpenditure_throwsIllegalValueException()
    -toModelType_validBudgetDetails_returnsBudget()
     */

    /*  @Test
    void toModelType_validBudgetDetails_returnsBudget() {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(VALID_NAME, VALID_EXPENDITURES);
        assertEquals(, budget);
    }*/

    @Test
    void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(null, VALID_EXPENDITURES);
        assertThrows(IllegalValueException.class, budget::toModelType);
    }

    @Test
    void toModelType_invalidNameBlank_throwsIllegalValueException() {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(INVALID_NAME_BLANK, VALID_EXPENDITURES);
        assertThrows(IllegalValueException.class, budget::toModelType);
    }

    @Test
    void toModelType_invalidNameNonAlphaNumeric_throwsIllegalValueException() {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(INVALID_NAME_NON_ALPHANUMERIC, VALID_EXPENDITURES);
        assertThrows(IllegalValueException.class, budget::toModelType);
    }

}

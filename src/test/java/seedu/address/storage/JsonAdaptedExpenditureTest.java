package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;

class JsonAdaptedExpenditureTest {
    public static final String INVALID_NAME = "#shirt";
    public static final String INVALID_PRICE = "0.100";
    public static final String INVALID_DATE = "08-10-2020";
    public static final List<JsonAdaptedTag> INVALID_TAGS = new ArrayList<>();

    public static final String VALID_NAME = "shirt";
    public static final String VALID_PRICE = "10.10";
    public static final String VALID_DATE = "2020-10-08";
    public static final List<JsonAdaptedTag> VALID_TAGS = new ArrayList<>();

    /*
    Todo:
    - toModelType_validExpenditureDetails_returnsExpenditure()
    - toModelType_invalidTags_throwsIllegalValueException()
     */

    /*@Test
    void toModelType_validExpenditureDetails_returnsExpenditure() {
    }*/

    @Test
    void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(INVALID_NAME,
                VALID_PRICE, VALID_DATE, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

    @Test
    void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(null,
                VALID_PRICE, VALID_DATE, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

    @Test
    void toModelType_invalidPrice_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(VALID_NAME,
                INVALID_PRICE, VALID_DATE, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

    @Test
    void toModelType_nullPrice_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(VALID_NAME,
                null, VALID_DATE, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

    @Test
    void toModelType_invalidDate_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(VALID_NAME,
                VALID_PRICE, INVALID_DATE, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

    @Test
    void toModelType_nullDate_throwsIllegalValueException() {
        JsonAdaptedExpenditure expenditure = new JsonAdaptedExpenditure(VALID_NAME,
                VALID_PRICE, null, VALID_TAGS);
        assertThrows(IllegalValueException.class, expenditure::toModelType);
    }

}

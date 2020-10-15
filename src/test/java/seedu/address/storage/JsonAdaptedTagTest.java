package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;

class JsonAdaptedTagTest {
    public static final String VALID_TAG = "entertainment";
    public static final String INVALID_TAG = "#household";

    @Test
    void getTagName() {
        JsonAdaptedTag tag = new JsonAdaptedTag(VALID_TAG);
        assertEquals(tag.getTagName(), VALID_TAG);
    }

    @Test
    void toModelType_invalidTag_throwsIllegalValueException() {
        JsonAdaptedTag tag = new JsonAdaptedTag(INVALID_TAG);
        assertThrows(IllegalValueException.class, tag::toModelType);
    }

}

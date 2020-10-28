package seedu.address.model.expenditure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalExpenditure.MC_MUFFIN;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ExpenditureBuilder;




class ExpenditureTest {

    @Test
    public void isSameExpenditure() {
        // same object -> returns true
        assertTrue(MC_MUFFIN.isSameExpenditure(MC_MUFFIN));

        // null -> returns false
        assertFalse(MC_MUFFIN.isSameExpenditure(null));

        // different createdOn -> returns false
        Expenditure editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN).withCreatedOn("2020-10-13").build();
        assertFalse(MC_MUFFIN.isSameExpenditure(editedMcmuffin));

        // different name -> returns false
        editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN).withName("McSpicy").build();
        assertFalse(MC_MUFFIN.isSameExpenditure(editedMcmuffin));

        // different price -> returns false
        editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN).withPrice("12.00").build();
        assertFalse(MC_MUFFIN.isSameExpenditure(editedMcmuffin));

        // same name, same createdOn, different tags -> returns true
        editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN).withTags("Burger").build();
        assertTrue(MC_MUFFIN.isSameExpenditure(editedMcmuffin));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Expenditure mcmuffinCopy = new ExpenditureBuilder(MC_MUFFIN).build();
        assertTrue(MC_MUFFIN.equals(mcmuffinCopy));

        // same object -> returns true
        assertTrue(MC_MUFFIN.equals(MC_MUFFIN));

        // null -> returns false
        assertFalse(MC_MUFFIN.equals(null));

        // different type -> returns false
        assertFalse(MC_MUFFIN.equals(5));

        // different budget -> returns false
        assertFalse(MC_MUFFIN.equals(new ExpenditureBuilder().build()));

        // different name -> returns false
        Expenditure editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN)
                .withName(ExpenditureBuilder.DEFAULT_NAME).build();
        assertFalse(MC_MUFFIN.equals(editedMcmuffin));

        // different createdOn -> returns false
        editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN)
                .withCreatedOn(ExpenditureBuilder.DEFAULT_CREATED_ON).build();
        assertFalse(MC_MUFFIN.equals(editedMcmuffin));

        // different price -> returns false
        editedMcmuffin = new ExpenditureBuilder(MC_MUFFIN)
                .withPrice(ExpenditureBuilder.DEFAULT_PRICE).build();
        assertFalse(MC_MUFFIN.equals(editedMcmuffin));
    }
    @Test
    void getName() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.getName(), new Name("McMuffin"));
    }

    @Test
    void getPrice() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.getPrice(), new Price("4.50"));
    }

    @Test
    void getCreatedOn() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.getCreatedOn(), new Date("2020-10-10"));
    }

    @Test
    void getFormattedCreatedOn() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.getFormattedCreatedOn(),
                java.sql.Date.valueOf(LocalDate.parse("2020-10-10")));
    }

    @Test
    void getTags() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.getTags(), new HashSet<>());
    }


    @Test
    void testToString() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertEquals(expectedExpenditure.toString(), "McMuffin");
    }

    @Test
    void contains() {
        Expenditure expectedExpenditure = MC_MUFFIN;
        assertTrue(expectedExpenditure.contains("MC"));
    }
}

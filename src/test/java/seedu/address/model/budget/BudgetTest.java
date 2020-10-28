package seedu.address.model.budget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalBudgets.MC_DONALDS;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.BudgetBuilder;
import seedu.address.testutil.TypicalExpenditures;

class BudgetTest {

    @Test
    public void isSameBudget() {
        // same object -> returns true
        assertTrue(MC_DONALDS.isSameBudget(MC_DONALDS));

        // null -> returns false
        assertFalse(MC_DONALDS.isSameBudget(null));

        // different createdOn -> returns false
        Budget editedMcdonalds = new BudgetBuilder(MC_DONALDS)
                .withCreatedOn(BudgetBuilder.DEFAULT_CREATED_ON)
                .build();
        assertFalse(MC_DONALDS.isSameBudget(editedMcdonalds));

        // different name -> returns false
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withName(BudgetBuilder.DEFAULT_NAME).build();
        assertFalse(MC_DONALDS.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different threshold -> returns true
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different expenditures -> returns true
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different attributes -> returns true
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD)
                .withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Budget mcdonaldsCopy = new BudgetBuilder(MC_DONALDS).build();
        assertTrue(MC_DONALDS.equals(mcdonaldsCopy));

        // same object -> returns true
        assertTrue(MC_DONALDS.equals(MC_DONALDS));

        // null -> returns false
        assertFalse(MC_DONALDS.equals(null));

        // different type -> returns false
        assertFalse(MC_DONALDS.equals(5));

        // different budget -> returns false
        assertFalse(MC_DONALDS.equals(new BudgetBuilder().build()));

        // different name -> returns false
        Budget editedMcdonalds = new BudgetBuilder(MC_DONALDS).withName(BudgetBuilder.DEFAULT_NAME).build();
        assertFalse(MC_DONALDS.equals(editedMcdonalds));

        // different createdOn -> returns false
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withCreatedOn(BudgetBuilder.DEFAULT_CREATED_ON).build();
        assertFalse(MC_DONALDS.equals(editedMcdonalds));

        // different threshold -> returns false
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD).build();
        assertFalse(MC_DONALDS.equals(editedMcdonalds));

        // different expenditures -> returns false
        editedMcdonalds = new BudgetBuilder(MC_DONALDS).withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertFalse(MC_DONALDS.equals(editedMcdonalds));
    }

    @Test
    void getName() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getName(), new Name("McDonalds"));
    }

    @Test
    void getCreatedOn() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getCreatedOn(), new Date("2020-10-11"));
    }

    @Test
    void getThreshold() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getCreatedOn(), new Date("2020-10-11"));
    }

    @Test
    void getExpenditures() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getExpenditures(), TypicalExpenditures.getTypicalExpenditures());
    }

    @Test
    void getExpenditureSize() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getExpenditureSize(), 3);
    }

    @Test
    void getTotalExpenditure() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.getTotalExpenditure(), "15.50");
    }

    @Test
    void addExpenditure() {
        Budget expectedBudget = MC_DONALDS;
        expectedBudget.addExpenditure(TypicalExpenditures.MC_MUFFIN);
        assertEquals(expectedBudget.getExpenditureSize(), 4);
    }

    @Test
    void testToString() {
        Budget expectedBudget = MC_DONALDS;
        assertEquals(expectedBudget.toString(), "McDonalds");
    }

    @Test
    void contains() {
        Budget expectedBudget = MC_DONALDS;
        assertTrue(expectedBudget.contains("MC"));
    }
}

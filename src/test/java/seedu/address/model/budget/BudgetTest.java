package seedu.address.model.budget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.model.expenditure.Expenditure;
import seedu.address.testutil.BudgetBuilder;
import seedu.address.testutil.ExpenditureBuilder;
import seedu.address.testutil.TypicalExpenditures;

class BudgetTest {

    private Expenditure mcMuffin = new ExpenditureBuilder().withName("McMuffin").withPrice("4.50")
            .withCreatedOn("2020-10-10").build();
    private Expenditure mcSpicy = new ExpenditureBuilder().withName("McSpicy").withPrice("7.00")
            .withCreatedOn("2020-10-11").build();
    private Expenditure mcNuggets = new ExpenditureBuilder().withName("McNuggets").withPrice("4.00")
            .withCreatedOn("2020-10-12").build();

    private List<Expenditure> expenditureList =
            new ArrayList<>(Arrays.asList(mcMuffin, mcNuggets, mcSpicy));

    private Budget mcDonalds = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-11")
            .withThreshold(Optional.of(new Threshold("1200")))
            .withExpenditures(expenditureList).build();

    @Test
    public void isSameBudget() {
        // same object -> returns true
        assertTrue(mcDonalds.isSameBudget(mcDonalds));

        // null -> returns false
        assertFalse(mcDonalds.isSameBudget(null));

        // different createdOn -> returns false
        Budget editedMcdonalds = new BudgetBuilder(mcDonalds)
                .withCreatedOn(BudgetBuilder.DEFAULT_CREATED_ON)
                .build();
        assertFalse(mcDonalds.isSameBudget(editedMcdonalds));

        // different name -> returns false
        editedMcdonalds = new BudgetBuilder(mcDonalds).withName(BudgetBuilder.DEFAULT_NAME).build();
        assertFalse(mcDonalds.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different threshold -> returns true
        editedMcdonalds = new BudgetBuilder(mcDonalds).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different expenditures -> returns true
        editedMcdonalds = new BudgetBuilder(mcDonalds).withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));

        // same name, same createdOn, different attributes -> returns true
        editedMcdonalds = new BudgetBuilder(mcDonalds).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD)
                .withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertTrue(editedMcdonalds.isSameBudget(editedMcdonalds));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Budget mcdonaldsCopy = new BudgetBuilder(mcDonalds).build();
        assertTrue(mcDonalds.equals(mcdonaldsCopy));

        // same object -> returns true
        assertTrue(mcDonalds.equals(mcDonalds));

        // null -> returns false
        assertFalse(mcDonalds.equals(null));

        // different type -> returns false
        assertFalse(mcDonalds.equals(5));

        // different budget -> returns false
        assertFalse(mcDonalds.equals(new BudgetBuilder().build()));

        // different name -> returns false
        Budget editedMcdonalds = new BudgetBuilder(mcDonalds).withName(BudgetBuilder.DEFAULT_NAME).build();
        assertFalse(mcDonalds.equals(editedMcdonalds));

        // different createdOn -> returns false
        editedMcdonalds = new BudgetBuilder(mcDonalds).withCreatedOn(BudgetBuilder.DEFAULT_CREATED_ON).build();
        assertFalse(mcDonalds.equals(editedMcdonalds));

        // different threshold -> returns false
        editedMcdonalds = new BudgetBuilder(mcDonalds).withThreshold(BudgetBuilder.DEFAULT_THRESHOLD).build();
        assertFalse(mcDonalds.equals(editedMcdonalds));

        // different expenditures -> returns false
        editedMcdonalds = new BudgetBuilder(mcDonalds).withExpenditures(BudgetBuilder.DEFAULT_EXPENDITURES).build();
        assertFalse(mcDonalds.equals(editedMcdonalds));
    }

    @Test
    void getName() {
        Budget expectedBudget = mcDonalds;
        assertEquals(new Name("McDonalds"), expectedBudget.getName());
    }

    @Test
    void getCreatedOn() {
        Budget expectedBudget = mcDonalds;
        assertEquals(new Date("2020-10-11"), expectedBudget.getCreatedOn());
    }

    @Test
    void getThreshold() {
        Budget expectedBudget = mcDonalds;
        assertEquals(new Date("2020-10-11"), expectedBudget.getCreatedOn());
    }

    @Test
    void getExpenditures() {
        Budget expectedBudget = mcDonalds;
        assertEquals(expenditureList, expectedBudget.getExpenditures());
    }

    @Test
    void getExpenditureSize() {
        Budget expectedBudget = mcDonalds;
        assertEquals(3, expectedBudget.getExpenditureSize());
    }

    @Test
    void getTotalExpenditure() {
        Budget expectedBudget = mcDonalds;
        assertEquals("15.50", expectedBudget.getTotalExpenditure());
    }

    @Test
    void addExpenditure() {
        Budget expectedBudget = mcDonalds;
        expectedBudget.addExpenditure(TypicalExpenditures.MC_MUFFIN);
        assertEquals(4, expectedBudget.getExpenditureSize());
    }

    @Test
    void testToString() {
        Budget expectedBudget = mcDonalds;
        assertEquals("McDonalds", expectedBudget.toString());
    }

    @Test
    void contains() {
        Budget expectedBudget = mcDonalds;
        assertTrue(expectedBudget.contains("MC"));
    }
}

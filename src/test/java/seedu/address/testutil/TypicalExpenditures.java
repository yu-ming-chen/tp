package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.expenditure.ExpenditureList;

public class TypicalExpenditures {
    public static final Expenditure MC_MUFFIN = new ExpenditureBuilder().withName("McMuffin").withPrice("4.50")
            .withCreatedOn("2020-10-10").build();
    public static final Expenditure MC_SPICY = new ExpenditureBuilder().withName("McSpicy").withPrice("7.00")
            .withCreatedOn("2020-10-11").build();
    public static final Expenditure MC_NUGGETS = new ExpenditureBuilder().withName("McNuggets").withPrice("4.00")
            .withCreatedOn("2020-10-12").build();

    public static final ExpenditureList EXPENDITURE_LIST =
            new ExpenditureList(new ArrayList<>(Arrays.asList(MC_MUFFIN, MC_NUGGETS, MC_SPICY)));

    private TypicalExpenditures() {} // prevents instantiation

    public static ExpenditureList getTypicalExpenditures() {
        return EXPENDITURE_LIST;
    }
}

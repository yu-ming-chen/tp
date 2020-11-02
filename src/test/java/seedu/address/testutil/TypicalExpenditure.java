package seedu.address.testutil;

import seedu.address.model.expenditure.Expenditure;

public class TypicalExpenditure {
    public static final Expenditure MC_MUFFIN = new ExpenditureBuilder().withName("McMuffin").withPrice("4.50")
            .withCreatedOn("2020-10-10").build();

    public static Expenditure getTypicalExpenditure() {
        return MC_MUFFIN;
    }
}

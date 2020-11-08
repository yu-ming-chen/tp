package seedu.address.testutil;

import seedu.address.model.budget.Budget;

public class TypicalBudget {

    public static final String MC_DONALDS_NAME = "McDonalds";
    public static final String MC_DONALDS_THRESHOLD = "100";
    public static final String MC_DONALDS_CREATED_ON = "2020-10-10";

    public static final String KFC_NAME = "KFC";
    public static final String KFC_THRESHOLD = "80";
    public static final String KFC_CREATED_ON = "2020-10-09";

    public static final String SUBWAY_NAME = "Subway";
    public static final String SUBWAY_THRESHOLD = "80";
    public static final String SUBWAY_CREATED_ON = "2020-10-08";

    public static final Budget MC_DONALDS = new BudgetBuilder().withName(MC_DONALDS_NAME)
            .withThreshold(MC_DONALDS_THRESHOLD).withCreatedOn(MC_DONALDS_CREATED_ON)
            .withExpenditures(TypicalExpenditures.MC_DONALDS_EXPENDITURES).build();

    public static final Budget KFC = new BudgetBuilder().withName(KFC_NAME)
            .withThreshold(KFC_THRESHOLD).withCreatedOn(KFC_CREATED_ON)
            .withExpenditures(TypicalExpenditures.KFC_EXPENDITURES).build();

    public static final Budget SUBWAY = new BudgetBuilder().withName(SUBWAY_NAME)
            .withThreshold(SUBWAY_THRESHOLD).withCreatedOn(SUBWAY_CREATED_ON)
            .withExpenditures(TypicalExpenditures.SUBWAY_EXPENDITURES).build();

    public static Budget getMcDonaldsBudget() {
        return new BudgetBuilder().withName(MC_DONALDS_NAME)
                .withThreshold(MC_DONALDS_THRESHOLD).withCreatedOn(MC_DONALDS_CREATED_ON)
                .withExpenditures(TypicalExpenditures.MC_DONALDS_EXPENDITURES).build();
    }

    public static Budget getKfcBudget() {
        return new BudgetBuilder().withName(KFC_NAME)
                .withThreshold(KFC_THRESHOLD).withCreatedOn(KFC_CREATED_ON)
                .withExpenditures(TypicalExpenditures.KFC_EXPENDITURES).build();
    }

    public static Budget getSubwayExpenditure() {
        return new BudgetBuilder().withName(SUBWAY_NAME)
                .withThreshold(SUBWAY_THRESHOLD).withCreatedOn(SUBWAY_CREATED_ON)
                .withExpenditures(TypicalExpenditures.SUBWAY_EXPENDITURES).build();
    }
}

package seedu.address.testutil;

import seedu.address.model.Nusave;
import seedu.address.model.budget.Budget;

public class TypicalBudgets {
    public static final Budget MC_DONALDS = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-10")
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();

    private TypicalBudgets() {} // prevents instantiation

    public static final Nusave getTypicalNusave() {
        Nusave nusave = new Nusave();
        nusave.addBudget(MC_DONALDS);
        return nusave;
    }
}

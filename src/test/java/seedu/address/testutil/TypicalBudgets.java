package seedu.address.testutil;

import java.util.Optional;

import seedu.address.model.Nusave;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Threshold;

public class TypicalBudgets {
    public static final Budget MC_DONALDS = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-11")
            .withThreshold(Optional.of(new Threshold("1200")))
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();

    private TypicalBudgets() {} // prevents instantiation

    public static final Nusave getTypicalNusave() {
        Nusave nusave = new Nusave();
        nusave.addBudget(MC_DONALDS);
        return nusave;
    }
}

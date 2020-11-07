package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import seedu.address.model.Nusave;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.ExpenditureList;

public class TypicalBudgets {
    public static final Budget MC_DONALDS = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-11")
            .withThreshold(Optional.of(new Threshold("1200")))
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();

    public static final Budget KFC = new BudgetBuilder().withName("KFC").withCreatedOn("2020-11-11")
            .withThreshold(Optional.of(new Threshold("100")))
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();

    public static final Budget SUBWAY = new BudgetBuilder().withName("Subway").withCreatedOn("2020-12-11")
            .withThreshold(Optional.of(new Threshold("200")))
            .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();

    public static final BudgetList BUDGET_LIST = new BudgetList(
            new ArrayList<>(Arrays.asList(MC_DONALDS, KFC, SUBWAY)));

    private TypicalBudgets() {} // prevents instantiation

    public static final Nusave getTypicalNusave() {
        Nusave nusave = new Nusave();
        nusave.addBudget(MC_DONALDS);
        nusave.addBudget(KFC);
        nusave.addBudget(SUBWAY);
        return nusave;
    }
}

package seedu.address.testutil;

import java.util.Arrays;

import seedu.address.model.Nusave;
import seedu.address.model.budget.BudgetList;

public class TypicalBudgets {
    public static final BudgetList FAST_FOOD_BUDGETS = new BudgetList(
            Arrays.asList(
                    TypicalBudget.MC_DONALDS,
                    TypicalBudget.KFC,
                    TypicalBudget.SUBWAY
            ));

    private TypicalBudgets() {} // prevents instantiation

    public static BudgetList getFastFoodBudgets() {
        BudgetList budgetList = new BudgetList();
        budgetList.addToFront(TypicalBudget.getMcDonaldsBudget());
        budgetList.addToFront(TypicalBudget.getKfcBudget());
        budgetList.addToFront(TypicalBudget.getSubwayExpenditure());
        return budgetList;
    }

    public static Nusave getTypicalNusave() {
        Nusave nusave = new Nusave();
        nusave.setBudgets(getFastFoodBudgets());
        return nusave;
    }
}

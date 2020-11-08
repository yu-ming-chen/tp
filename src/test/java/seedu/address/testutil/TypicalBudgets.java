package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.Nusave;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetList;
import seedu.address.model.budget.Threshold;

public class TypicalBudgets {
    public static final Budget MC_DONALDS = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-05-11")
            .withThreshold(Optional.of(new Threshold("1200")))
            .withExpenditures(TypicalExpenditures.EXPENDITURE_LIST_MCDONALDS).build();

    public static final Budget KFC = new BudgetBuilder().withName("KFC").withCreatedOn("2020-12-11")
            .withThreshold(Optional.of(new Threshold("100")))
            .withExpenditures(TypicalExpenditures.EXPENDITURE_LIST_KFC).build();

    public static final Budget SUBWAY = new BudgetBuilder().withName("Subway").withCreatedOn("2020-01-11")
            .withThreshold(Optional.of(new Threshold("200")))
            .withExpenditures(TypicalExpenditures.EXPENDITURE_LIST_SUBWAY).build();

    public static final BudgetList BUDGET_LIST = new BudgetList(
            new ArrayList<>(Arrays.asList(MC_DONALDS, KFC, SUBWAY)));

    private TypicalBudgets() {} // prevents instantiation

    public static final Nusave getTypicalNusave() {
        Nusave nusave = new Nusave();
        nusave.addBudget(SUBWAY);
        nusave.addBudget(KFC);
        nusave.addBudget(MC_DONALDS);
        return nusave;
    }

    public static final ObservableList<Budget> typicalBudgetsAsObservableList() {
        ObservableList<Budget> internalBudgetList = FXCollections.observableArrayList();
        internalBudgetList.setAll(Arrays.asList(MC_DONALDS, KFC, SUBWAY));
        ObservableList<Budget> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalBudgetList);
        return internalUnmodifiableList;
    }

    public static final ObservableList<Budget> typicalBudgetsAsObservableListSortedByName() {
        ObservableList<Budget> internalBudgetList = FXCollections.observableArrayList();
        internalBudgetList.setAll(Arrays.asList(KFC, MC_DONALDS, SUBWAY));
        ObservableList<Budget> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalBudgetList);
        return internalUnmodifiableList;
    }
}

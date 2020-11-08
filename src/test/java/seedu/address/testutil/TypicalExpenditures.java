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

    public static final Expenditure CHICKEN = new ExpenditureBuilder().withName("Chicken").withPrice("6.50")
            .withCreatedOn("2020-01-06").build();
    public static final Expenditure BURGER = new ExpenditureBuilder().withName("Burger").withPrice("5.00")
            .withCreatedOn("2020-01-07").build();
    public static final Expenditure COKE = new ExpenditureBuilder().withName("Coke").withPrice("2.00")
            .withCreatedOn("2020-01-08").build();

    public static final Expenditure EGG_MAYO = new ExpenditureBuilder().withName("Egg Mayo").withPrice("5.50")
            .withCreatedOn("2018-10-10").build();
    public static final Expenditure COLD_CUT_TRIO = new ExpenditureBuilder().withName("Cold Cut Trio").withPrice("6.00")
            .withCreatedOn("2019-10-11").build();
    public static final Expenditure COOKIE = new ExpenditureBuilder().withName("Cookie").withPrice("1.50")
            .withCreatedOn("2020-10-12").build();

    public static final ExpenditureList EXPENDITURE_LIST_MCDONALDS =
            new ExpenditureList(new ArrayList<>(Arrays.asList(MC_MUFFIN, MC_NUGGETS, MC_SPICY)));

    public static final ExpenditureList EXPENDITURE_LIST_KFC =
            new ExpenditureList(new ArrayList<>(Arrays.asList(CHICKEN, BURGER, COKE)));

    public static final ExpenditureList EXPENDITURE_LIST_SUBWAY =
            new ExpenditureList(new ArrayList<>(Arrays.asList(EGG_MAYO, COLD_CUT_TRIO, COOKIE)));

    private TypicalExpenditures() {} // prevents instantiation

    public static ExpenditureList getTypicalExpenditures() {
        return EXPENDITURE_LIST_MCDONALDS;
    }
}

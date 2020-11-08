package seedu.address.testutil;

import java.util.Arrays;

import seedu.address.model.expenditure.ExpenditureList;

public class TypicalExpenditures {

    public static final ExpenditureList MC_DONALDS_EXPENDITURES = new ExpenditureList(
            Arrays.asList(
                    TypicalExpenditure.MC_MUFFIN,
                    TypicalExpenditure.MC_CHICKEN,
                    TypicalExpenditure.MC_SPICY
            ));

    public static final ExpenditureList KFC_EXPENDITURES = new ExpenditureList(
            Arrays.asList(
                    TypicalExpenditure.KFC_ZINGER,
                    TypicalExpenditure.KFC_CHEESE_FRIES,
                    TypicalExpenditure.KFC_BANDITO
            ));

    public static final ExpenditureList SUBWAY_EXPENDITURES = new ExpenditureList(
            Arrays.asList(
                    TypicalExpenditure.SUBWAY_COLD_CUT_TRIO,
                    TypicalExpenditure.SUBWAY_COOKIE,
                    TypicalExpenditure.SUBWAY_SOUP
            ));

    private TypicalExpenditures() {} // prevents instantiation

    public static ExpenditureList getMcDonaldsExpenditures() {
        ExpenditureList expenditureList = new ExpenditureList();
        expenditureList.addToFront(TypicalExpenditure.getMcMuffinExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getMcChickenExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getMcSpicyExpenditure());
        return expenditureList;
    }

    public static ExpenditureList getKfcExpenditures() {
        ExpenditureList expenditureList = new ExpenditureList();
        expenditureList.addToFront(TypicalExpenditure.getKfcZingerExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getKfcCheeseFriesExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getKfcBanditoExpenditure());
        return expenditureList;
    }

    public static ExpenditureList getSubwayExpenditures() {
        ExpenditureList expenditureList = new ExpenditureList();
        expenditureList.addToFront(TypicalExpenditure.getSubwayColdCutTrioExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getSubwayCookieExpenditure());
        expenditureList.addToFront(TypicalExpenditure.getSubwaySoupExpenditure());
        return expenditureList;
    }
}

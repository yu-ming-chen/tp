package seedu.address.model;

import java.util.Comparator;

import seedu.address.model.budget.Budget;

public class SortBudgetByName implements Comparator<Budget> {

    @Override
    public int compare(Budget a, Budget b) {
        return a.getName().value.toLowerCase().compareTo(b.getName().value.toLowerCase());
    }
}

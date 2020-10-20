package seedu.address.model;

import java.util.Comparator;

import seedu.address.model.budget.Budget;

public class SortBudgetByCreateDate implements Comparator<Budget> {

    @Override
    public int compare(Budget a, Budget b) {
        return a.getCreatedOn().compareTo(b.getCreatedOn());
    }
}

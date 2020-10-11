package seedu.address.model;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;

public interface ReadOnlyNusave {
    ObservableList<Budget> getBudgetList();
    List<Budget> getBudgets();
}

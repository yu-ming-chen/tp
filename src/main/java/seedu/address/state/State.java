package seedu.address.state;

import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public interface State {

    Optional<Integer> getBudgetIndex();

    Page getPage();

    BooleanProperty getIsBudgetPageProp();

    StringProperty getTotalExpenditureStringProp();

    boolean isBudgetPage();

    String getPageTitle();

    boolean isMain();

    boolean isBudget();

    void setIsBudgetPage(boolean isExpenditure);

    void setPage(Page page);

    void setTotalExpenditure(String expenditure);

    void setBudgetIndex(BudgetIndex index);

    void setPageName(String pageTitle);
}

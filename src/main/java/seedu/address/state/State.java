package seedu.address.state;

import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public interface State {

    Optional<Integer> getBudgetIndex();

    Page getPage();

    BooleanProperty getIsExpenditureProp();

    boolean getIsExpenditure();

    String getPageTitle();

    boolean isMain();

    boolean isBudget();

    void setIsExpenditurePage(boolean isExpenditure);

    void setPage(Page page);

    void setBudgetIndex(BudgetIndex index);

    void setPageName(String pageTitle);
}

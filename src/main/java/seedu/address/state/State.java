package seedu.address.state;

import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public interface State {

    Optional<Integer> getBudgetIndex();

    Page getPage();

    BooleanProperty getIsBudgetPageProp();

    boolean isBudgetPage();

    String getPageTitle();

    Optional<String> getSearchTerm();

    boolean isMain();

    boolean isBudget();

    void setIsBudgetPage(boolean isExpenditure);

    void setPage(Page page);

    void setBudgetIndex(BudgetIndex index);

    void setPageName(String pageTitle);

    void setSearchTerm(String searchTerm);

    void clearSearchTerm();
}

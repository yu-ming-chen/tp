package seedu.address.state;

import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public class StateManager implements State {
    private BudgetIndex budgetIndex;
    private Page currentPage;
    private BooleanProperty isBudgetPageProp = new SimpleBooleanProperty(false);
    private String pageTitle;
    private Optional<String> searchTerm;

    /**
     * Constructs a {@code StateManager} with the given {@code BudgetIndex} and {@code Page}.
     * @param budgetIndex current budget index NUSave is accessed in.
     * @param currentPage current page NUSave is accessed in.
     * @param pageTitle Title of the current page.
     */
    public StateManager(BudgetIndex budgetIndex, Page currentPage, String pageTitle) {
        this.budgetIndex = budgetIndex;
        this.currentPage = currentPage;
        this.pageTitle = pageTitle;
        this.searchTerm = Optional.empty();
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return this.budgetIndex.getBudgetIndex();
    }

    @Override
    public Page getPage() {
        return this.currentPage;
    }

    @Override
    public BooleanProperty getIsBudgetPageProp() {
        return this.isBudgetPageProp;
    }

    @Override
    public boolean isBudgetPage() {
        return this.isBudgetPageProp.getValue();
    }

    @Override
    public String getPageTitle() {
        return this.pageTitle;
    }

    @Override
    public Optional<String> getSearchTerm() {
        return this.searchTerm;
    }

    @Override
    public boolean isMain() {
        return this.currentPage == Page.MAIN;
    }

    @Override
    public boolean isBudget() {
        return this.currentPage == Page.BUDGET;
    }

    @Override
    public void setIsBudgetPage(boolean isBudgetPage) {
        this.isBudgetPageProp.setValue(isBudgetPage);
    }

    @Override
    public void setPage(Page page) {
        this.currentPage = page;
        if (page == Page.BUDGET) {
            setIsBudgetPage(true);
        } else {
            setIsBudgetPage(false);
        }
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        this.budgetIndex = index;
    }

    @Override
    public void setPageName(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Override
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = Optional.of(searchTerm);
    }

    @Override
    public void clearSearchTerm() {
        this.searchTerm = Optional.empty();
    }

}

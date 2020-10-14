package seedu.address.state;

import java.util.Optional;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import seedu.address.state.budgetindex.BudgetIndex;

public class StateManager implements State {
    private BudgetIndex budgetIndex;
    private Page currentPage;
    private BooleanProperty isExpenditureProp = new SimpleBooleanProperty(false);
    private String pageTitle;

    /**
     * Constructs a {@code StateManager} with the given {@code BudgetIndex} and {@code Page}.
     * @param budgetIndex current budget index NUSave is accessed in.
     * @param currentPage current page NUSave is accessed in.
     */
    public StateManager(BudgetIndex budgetIndex, Page currentPage, String pageTitle) {
        this.budgetIndex = budgetIndex;
        this.currentPage = currentPage;
        this.pageTitle = pageTitle;
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
    public BooleanProperty getIsExpenditureProp() {
        return this.isExpenditureProp;
    }

    @Override
    public boolean isExpenditure() {
        return this.isExpenditureProp.getValue();
    }

    @Override
    public String getPageTitle() {
        return this.pageTitle;
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
    public void setIsExpenditurePage(boolean isExpenditurePage) {
        this.isExpenditureProp.setValue(isExpenditurePage);
    }

    @Override
    public void setPage(Page page) {
        this.currentPage = page;
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        this.budgetIndex = index;
    }

    @Override
    public void setPageName(String pageTitle) {
        this.pageTitle = pageTitle;
    }

}

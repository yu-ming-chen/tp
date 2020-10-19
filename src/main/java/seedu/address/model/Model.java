package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.budget.Budget;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.expenditureindex.ExpenditureIndex;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Renderable> PREDICATE_SHOW_ALL_RENDERABLES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getNusaveFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setNusavePath(Path nusaveFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setNusave(ReadOnlyNusave nusave);

    ReadOnlyNusave getNusave();

    void addBudget(Budget budget);

    void deleteBudget(BudgetIndex budget) throws CommandException;

    void deleteAllBudgets();

    void sortAllBudget();

    void deleteExpenditure(ExpenditureIndex expenditure) throws CommandException;

    void addExpenditure(Expenditure expenditure) throws CommandException;

    Page getPage();

    String getPageName(BudgetIndex index);

    String getPageTitle();

    boolean isExpenditure();

    BooleanProperty getIsExpenditureProp();

    void setIsExpenditurePage(boolean isExpenditurePage);

    void setPage(Page page);

    void setBudgetIndex(BudgetIndex index);

    void setPageName(String page);

    boolean isMain();

    boolean isBudget();

    /** Returns an unmodifiable view of the filtered renderable list */
    ObservableList<Renderable> getFilteredRenderableList();

    void updateFilteredRenderableList(Predicate<Renderable> predicate) throws CommandException;

    void repopulateObservableList() throws CommandException;
}

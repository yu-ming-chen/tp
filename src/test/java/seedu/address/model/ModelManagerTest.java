package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalBudgets.getTypicalNusave;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.budget.Budget;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.testutil.BudgetBuilder;
import seedu.address.testutil.TypicalExpenditures;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        //assertEquals(new Nusave(), new Nusave(modelManager.getNusave()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }


    @Test
    void getNusaveFilePath_validPath_getsNusaveFilePath() {
        Path path = Paths.get("data", "nusave.json");
        assertEquals(path, modelManager.getNusaveFilePath());
    }

    @Test
    void setNusavePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setNusavePath(null));
    }

    @Test
    void setNusavePath_validPath_setsNusavePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setNusavePath(path);
        assertEquals(path, modelManager.getNusaveFilePath());
    }

    @Test
    void setNusave_nullNusave_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setNusave(null));
    }

    /*
    @Test
    void setNusave_validNusave_setsNusave() {
        ReadOnlyNusave nusave = new Nusave();
        modelManager.setNusave(nusave);
        assertEquals(nusave, modelManager.getNusave());
    }

    @Test
    void getNusave() {
    }*/

    @Test
    void openBudget_nullBudget_throwsAssertionError() {
        BudgetIndex budgetIndex = new BudgetIndexManager(2);
        assertThrows(AssertionError.class, () -> modelManager.openBudget(budgetIndex));
    }

    @Test
    void openBudget_validOpenBudget_opensBudget() {
        modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        assertEquals(modelManager.getBudgetIndex().get(), 0);
        assertEquals(modelManager.getPage(), Page.BUDGET);
        assertTrue(modelManager.isBudgetPage());
    }

    @Test
    void closeBudget_validCloseBudget_closesBudget() {
        modelManager.closeBudget();
        assertEquals(modelManager.getBudgetIndex(), Optional.empty());
        assertEquals(modelManager.getPage(), Page.MAIN);
        assertTrue(modelManager.isMain());
    }

    @Test
    void addBudget_nullBudget_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.addBudget(null));
    }

    @Test
    void addBudget_validBudget_addsBudget() {
        modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        int size = modelManager.getNusave().getBudgetList().size();
        assertEquals(size, 1);
    }

    @Test
    void deleteBudget_nullBudget_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> modelManager.deleteBudget(new BudgetIndexManager(0)));
    }

    @Test
    void deleteBudget_validBudget_deletesBudget() {
        modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.deleteBudget(new BudgetIndexManager(0));
        int size = modelManager.getNusave().getBudgetList().size();
        assertEquals(size, 0);
    }

    @Test
    void editBudget_validBudget_deletesBudget() {
        modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        Budget oldBudget = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-10")
                .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();
        Budget newBudget = new BudgetBuilder().withName("KFC").withCreatedOn("2020-10-10")
                .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();
        modelManager.editBudget(oldBudget, newBudget);
        assertEquals(modelManager.getNusave().getBudgetList().get(0), newBudget);
    }

    @Test
    void deleteAllBudgets() {
        modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.deleteAllBudgets();
        assertEquals(modelManager.getNusave().getBudgetList().size(), 0);
    }

    @Test
    void sortBudgetsByName() {
        Budget a = new BudgetBuilder().withName("A").withCreatedOn("2020-10-10")
                .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();
        Budget b = new BudgetBuilder().withName("B").withCreatedOn("2020-10-10")
                .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();
        Budget c = new BudgetBuilder().withName("C").withCreatedOn("2020-10-10")
                .withExpenditures(TypicalExpenditures.getTypicalExpenditures()).build();
        modelManager.addBudget(c);
        modelManager.addBudget(b);
        modelManager.addBudget(a);
        modelManager.sortBudgetsByName();
        assertEquals(modelManager.getNusave().getBudgetList().get(0), a);
        assertEquals(modelManager.getNusave().getBudgetList().get(1), b);
        assertEquals(modelManager.getNusave().getBudgetList().get(2), c);
    }

    @Test
    void sortBudgetsByCreatedDate() {
    }

    @Test
    void deleteExpenditure() {
    }

    @Test
    void addExpenditure() {
    }

    @Test
    void editExpenditure() {
    }

    @Test
    void sortExpendituresByName() {
    }

    @Test
    void sortExpenditureByCreatedDate() {
    }

    @Test
    void calculateExpenditureValue() {
    }

    @Test
    void repopulateObservableList() {
    }

    @Test
    void isMain() {
    }

    @Test
    void isBudget() {
    }

    @Test
    void isWithinRange() {
    }

    @Test
    void testIsWithinRange() {
    }

    @Test
    void getPage() {
    }

    @Test
    void getBudgetPageProp() {
    }

    @Test
    void getTotalExpenditureStringProp() {
    }

    @Test
    void getPageName() {
    }

    @Test
    void getPageTitle() {
    }

    @Test
    void getTotalExpenditureValue() {
    }

    @Test
    void getThreshold() {
    }

    @Test
    void isBudgetPage() {
    }

    @Test
    void setBudgetIndex() {
    }

    @Test
    void setPage() {
    }

    @Test
    void setTotalExpenditure() {
    }

    @Test
    void setPageName() {
    }

    @Test
    void getFilteredRenderableList() {
    }

    @Test
    void updateFilteredRenderableList() {
    }
}

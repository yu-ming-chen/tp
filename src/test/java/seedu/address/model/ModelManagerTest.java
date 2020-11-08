package seedu.address.model;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalBudget.*;
import static seedu.address.testutil.TypicalBudgets.getTypicalNusave;
import static seedu.address.testutil.TypicalExpenditure.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.budget.Budget;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.state.expenditureindex.ExpenditureIndex;
import seedu.address.state.expenditureindex.ExpenditureIndexManager;

public class ModelManagerTest {

    @Test
    public void constructor() {
        ModelManager modelManager = new ModelManager();
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        //assertEquals(new Nusave(), new Nusave(modelManager.getNusave()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        ModelManager modelManager = new ModelManager();
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }


    @Test
    void getNusaveFilePath_validPath_getsNusaveFilePath() {
        ModelManager modelManager = new ModelManager();
        Path path = Paths.get("data", "nusave.json");
        assertEquals(path, modelManager.getNusaveFilePath());
    }

    @Test
    void setNusavePath_nullPath_throwsNullPointerException() {
        ModelManager modelManager = new ModelManager();
        assertThrows(NullPointerException.class, () -> modelManager.setNusavePath(null));
    }

    @Test
    void setNusavePath_validPath_setsNusavePath() {
        ModelManager modelManager = new ModelManager();
        Path path = Paths.get("address/book/file/path");
        modelManager.setNusavePath(path);
        assertEquals(path, modelManager.getNusaveFilePath());
    }

    @Test
    void setNusave_nullNusave_throwsNullPointerException() {
        ModelManager modelManager = new ModelManager();
        assertThrows(NullPointerException.class, () -> modelManager.setNusave(null));
    }

    /*
    @Test
    void setNusave_validNusave_setsNusave() {
        ReadOnlyNusave nusave = new Nusave();
        modelManager.setNusave(nusave);
        assertEquals(nusave, modelManager.getNusave());
    }*/

    @Test
    void getNusave() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        ReadOnlyNusave nusaveToCheck = getTypicalNusave();
        ReadOnlyNusave nusave = modelManager.getNusave();
        assertEquals(nusave, nusaveToCheck);
    }

    @Test
    void openBudget_nullBudget_throwsAssertionError() {
        ModelManager modelManager = new ModelManager();
        BudgetIndex budgetIndex = new BudgetIndexManager(2);
        assertThrows(AssertionError.class, () -> modelManager.openBudget(budgetIndex));
    }

    @Test
    void openBudget_validOpenBudget_opensBudget() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        assertEquals(modelManager.getBudgetIndex().get(), 0);
        assertEquals(modelManager.getPage(), Page.BUDGET);
        assertTrue(modelManager.isBudgetPage());
    }

    @Test
    void closeBudget_validCloseBudget_closesBudget() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        modelManager.closeBudget();
        assertEquals(modelManager.getBudgetIndex(), Optional.empty());
        assertEquals(modelManager.getPage(), Page.MAIN);
        assertTrue(modelManager.isMain());
    }

    @Test
    void addBudget_nullBudget_throwsNullPointerException() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        assertThrows(NullPointerException.class, () -> modelManager.addBudget(null));
    }

    @Test
    void addBudget_validBudget_addsBudget() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        int size = modelManager.getNusave().getBudgetListAsObservableList().size();
        assertEquals(size, 3);
    }

    @Test
    void deleteBudget_nullBudget_throwsAssertionError() {
        ModelManager modelManager = new ModelManager();
        assertThrows(AssertionError.class, () -> modelManager.deleteBudget(new BudgetIndexManager(0)));
    }

    @Test
    void deleteBudget_validBudget_deletesBudget() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.deleteBudget(new BudgetIndexManager(0));
        int size = modelManager.getNusave().getBudgetListAsObservableList().size();
        assertEquals(size, 2);
    }

    //@Test
    //void editBudget_validBudget_deletesBudget() {
    //    modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
    //    Budget oldBudget = new BudgetBuilder().withName("McDonalds").withCreatedOn("2020-10-10")
    //            .withExpenditures(TypicalExpenditures.EXPENDITURE_LIST_MCDONALDS).build();
    //    Budget newBudget = new BudgetBuilder().withName("KFC").withCreatedOn("2020-10-10")
    //            .withExpenditures(TypicalExpenditures.EXPENDITURE_LIST_KFC).build();
    //    modelManager.editBudget(oldBudget, newBudget);
    //    System.out.println(modelManager.getNusave().getBudgetListAsObservableList());
    //    assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(0), newBudget);
    //}

    @Test
    void deleteAllBudgets() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.deleteAllBudgets();
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().size(), 0);
    }

    @Test
    void sortBudgetsByName() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());

        modelManager.addBudget(getSubwayBudget());
        modelManager.addBudget(getMcDonaldsBudget());
        modelManager.sortBudgetsByName();

        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(0), KFC);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(1), MC_DONALDS);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(2), MC_DONALDS);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(3), SUBWAY);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(4), SUBWAY);
    }

    @Test
    void sortBudgetsByCreatedDate() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());

        modelManager.addBudget(getMcDonaldsBudget());
        modelManager.sortBudgetsByCreatedDate();

        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(0), MC_DONALDS);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(1), MC_DONALDS);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(2), KFC);
        assertEquals(modelManager.getNusave().getBudgetListAsObservableList().get(3), SUBWAY);
    }

    @Test
    void deleteExpenditure() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        modelManager.deleteExpenditure(new ExpenditureIndexManager(1));
        assertEquals(2, modelManager.getFilteredRenderableList().size());
        assertEquals(SUBWAY_SOUP, modelManager.getFilteredRenderableList().get(0));
        assertEquals(SUBWAY_COLD_CUT_TRIO, modelManager.getFilteredRenderableList().get(1));
    }

    @Test
    void addExpenditure() {
//        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
//        modelManager.openBudget(new BudgetIndexManager(0));
//        modelManager.addExpenditure(MC_MUFFIN);
//        assertEquals(4, modelManager.getFilteredRenderableList().size());
//        assertEquals(MC_MUFFIN, modelManager.getFilteredRenderableList().get(0));
//        assertEquals(SUBWAY_COLD_CUT_TRIO, modelManager.getFilteredRenderableList().get(1));
//        assertEquals(SUBWAY_COOKIE, modelManager.getFilteredRenderableList().get(2));
//        assertEquals(SUBWAY_SOUP, modelManager.getFilteredRenderableList().get(3));
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
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        assertEquals(true, modelManager.isMain());
    }

    @Test
    void isBudget() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        assertEquals(false, modelManager.isBudget());
    }

    @Test
    void isWithinRange_validBudgetIndex_True() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        BudgetIndex validBudgetIndex = new BudgetIndexManager(2);
        assertEquals(true, modelManager.isWithinRange(validBudgetIndex));
    }

    @Test
    void isWithinRange_budgetIndexIsMoreThanListSize_False() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        BudgetIndex invalidBudgetIndex = new BudgetIndexManager(3);
        assertEquals(false, modelManager.isWithinRange(invalidBudgetIndex));
    }

    @Test
    void isWithinRange_validExpenditureIndex_True() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        ExpenditureIndex expenditureIndex = new ExpenditureIndexManager(1);
        assertTrue(modelManager.isWithinRange(expenditureIndex));
    }

    @Test
    void isWithinRange_expenditureIndexIsMoreThanListSize_False() {
        ModelManager modelManager = new ModelManager(getTypicalNusave(), new UserPrefs());
        modelManager.openBudget(new BudgetIndexManager(0));
        ExpenditureIndex expenditureIndex = new ExpenditureIndexManager(5);
        assertFalse(modelManager.isWithinRange(expenditureIndex));
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

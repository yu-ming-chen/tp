package seedu.address.logic.commands.budget;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.main.OpenBudgetCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.sort.SortType;
import seedu.address.state.budgetindex.BudgetIndexManager;
import seedu.address.testutil.TypicalBudgets;

class SortExpenditureCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() throws CommandException {
        model = new ModelManager(TypicalBudgets.getTypicalNusave(), new UserPrefs());
        expectedModel = new ModelManager(model.getNusave(), new UserPrefs());
        OpenBudgetCommand command = new OpenBudgetCommand(new BudgetIndexManager(1));
        command.execute(model);
        command.execute(expectedModel);
    }

    @Test
    public void execute_sortBudgetByTime_showsSortedList() {
        SortExpenditureCommand command = new SortExpenditureCommand(SortType.TIME);
        command.execute(expectedModel);
        assertCommandSuccess(new SortExpenditureCommand(SortType.TIME), model,
                SortExpenditureCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortBudgetByName_showsSortedList() {
        SortExpenditureCommand command = new SortExpenditureCommand(SortType.NAME);
        command.execute(expectedModel);
        assertCommandSuccess(new SortExpenditureCommand(SortType.NAME), model,
                SortExpenditureCommand.MESSAGE_SUCCESS, expectedModel);
    }
}

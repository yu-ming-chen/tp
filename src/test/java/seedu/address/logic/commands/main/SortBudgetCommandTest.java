package seedu.address.logic.commands.main;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.sort.SortType;
import seedu.address.testutil.TypicalBudgets;

class SortBudgetCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(TypicalBudgets.getTypicalNusave(), new UserPrefs());
        expectedModel = new ModelManager(model.getNusave(), new UserPrefs());
    }

    @Test
    public void execute_sortBudgetByTime_showsSortedList() throws CommandException {
        SortBudgetCommand command = new SortBudgetCommand(SortType.TIME);
        command.execute(expectedModel);
        assertCommandSuccess(new SortBudgetCommand(SortType.TIME), model,
                SortBudgetCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_sortBudgetByName_showsSortedList() throws CommandException {
        SortBudgetCommand command = new SortBudgetCommand(SortType.NAME);
        command.execute(expectedModel);
        assertCommandSuccess(new SortBudgetCommand(SortType.NAME), model,
                SortBudgetCommand.MESSAGE_SUCCESS, expectedModel);
    }

}

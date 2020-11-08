package seedu.address.logic.commands.main;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.main.HelpBudgetCommand.HELP_MESSAGE;

import static org.junit.jupiter.api.Assertions.*;

class HelpBudgetCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(HELP_MESSAGE, false, false);
        assertCommandSuccess(new HelpBudgetCommand(), model, expectedCommandResult, expectedModel);
    }
}
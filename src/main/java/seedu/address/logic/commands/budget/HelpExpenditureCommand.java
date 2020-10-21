package seedu.address.logic.commands.budget;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpExpenditureCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows a list of commands that is currently available.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Here are the list of available command:\n"
            + "1. help:\n"
            + "- Shows a list of available commands with descriptions in NUSave.\n"
            + "2. close:\n"
            + "Closes the budget currently open in NUSave.\n"
            + "3. add n/NAME n/PRICE:\n"
            + "Adds an Expenditure to the Budget with given NAME and given PRICE\n"
            + "4. delete INDEX:\n"
            + "Deletes the specific expenditure at the given INDEX from NUSave.\n"
            + "5. list:\n"
            + "Shows a list of all expenditures in the current budget in NUSave.\n"
            + "6. find KEYWORD:\n"
            + "Finds expenditures whose names contain the given KEYWORD.\n"
            + "7. sort:\n"
            + "Sort all expenditures in the current budget in NUSave by name.\n"
            + "8. exit:\n"
            + "Exits the program.\n";

    /**
     * Executes the help command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     */
    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false);
    }
}

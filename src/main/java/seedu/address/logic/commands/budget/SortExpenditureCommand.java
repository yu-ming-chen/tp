package seedu.address.logic.commands.budget;


import seedu.address.logic.commands.BudgetPageCommand;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Creates a new SortExpenditureCommand.
 */
public class SortExpenditureCommand extends BudgetPageCommand {
    public static final String COMMAND_WORD = "sort";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String DESCRIPTION = "Sorts expenditure by name.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n";

    public static final String MESSAGE_SUCCESS = "Sorted expenditures by name.";

    /**
     * Executes the sort expenditure command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.sortExpendituresByName();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}

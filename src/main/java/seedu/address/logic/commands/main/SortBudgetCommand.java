package seedu.address.logic.commands.main;


import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.model.Model;

import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;

/**
 * Creates a new SortBudgetCommand.
 */
public class SortBudgetCommand extends MainPageCommand {
    public static final String COMMAND_WORD = "sort";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String DESCRIPTION = "Sorts budget by name.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n";

    public static final String MESSAGE_SUCCESS = "Sorted budgets by name.";

    /**
     * Executes the create budget command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     */
    @Override
    public CommandResult execute(Model model) {
        model.sortBudgetsByName();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}

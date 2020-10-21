package seedu.address.logic.commands.main;

import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;

/**
 * Creates a new Budget.
 */
public class CreateBudgetCommand extends MainPageCommand {
    public static final String COMMAND_WORD = "create";
    public static final String SYNTAX = "create " + PREFIX_NAME + "NAME " + "(" + PREFIX_PRICE + "THRESHOLD)";
    public static final String DESCRIPTION = "Creates a budget.";
    public static final String MESSAGE_USAGE = "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n"
            + "Parameters: " + PREFIX_NAME + "NAME\n"
            + "                            " + PREFIX_PRICE + "THRESHOLD " + "(Optional)\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_NAME + "Daily Expenses " + PREFIX_PRICE + "200\n"
            + "                     " + COMMAND_WORD + " " + PREFIX_NAME + "Daily Expenses";

    public static final String MESSAGE_SUCCESS = "Created a new budget: %1$s";

    private final Budget toCreate;

    /**
     * Creates a new CreateBudgetCommand to create the spcified {@code budget}
     * @param toCreate the budget to be created
     */
    public CreateBudgetCommand(Budget toCreate) {
        this.toCreate = toCreate;
    }

    /**
     * Executes the create budget command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     */
    @Override
    public CommandResult execute(Model model) {
        model.addBudget(toCreate);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toCreate));
    }
}

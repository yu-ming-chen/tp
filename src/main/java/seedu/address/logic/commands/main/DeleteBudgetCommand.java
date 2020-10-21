package seedu.address.logic.commands.main;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.budgetindex.BudgetIndex;

public class DeleteBudgetCommand extends Command {
    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a budget\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_BUDGET_SUCCESS = "Deleted budget.";

    private final BudgetIndex toDelete;

    /**
     * Creates a DeleteBudgetCommand to delete the specified {@code budget}
     * @param budget the budget to be deleted
     */
    public DeleteBudgetCommand(BudgetIndex budget) {
        requireNonNull(budget);
        this.toDelete = budget;
    }

    /**
     * Executes the delete budget command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (!model.isWithinRange(toDelete)) {
            throw new CommandException(Messages.BUDGET_MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        model.deleteBudget(toDelete);
        return new CommandResult(MESSAGE_DELETE_BUDGET_SUCCESS);
    }
}

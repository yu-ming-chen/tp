package seedu.address.logic.commands.main;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.budgetindex.BudgetIndex;

public class DeleteBudgetCommand extends Command {
    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a Budget \n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_BUDGET_SUCCESS = "Deleted Budget";

    private final BudgetIndex toDelete;

    /**
     * Creates a DeleteBudgetCommand to delete the specified {@code budget}
     */
    public DeleteBudgetCommand(BudgetIndex budget) {
        requireNonNull(budget);
        this.toDelete = budget;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.deleteBudget(toDelete);
        return new CommandResult(MESSAGE_DELETE_BUDGET_SUCCESS);
    }
}

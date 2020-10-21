package seedu.address.logic.commands.budget;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.expenditureindex.ExpenditureIndex;

/**
 * Deletes an expenditure from a specific Budget.
 */
public class DeleteExpenditureCommand extends Command {
    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an expenditure\n"
            + "Parameters: INDEX \n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_EXPENDITURE_SUCCESS = "Deleted expenditure.";

    private final ExpenditureIndex toDelete;

    /**
     * Creates a DeleteExpenditureCommand to delete the specified {@code expenditure}
     * @param expenditure the expenditure to be deleted
     */
    public DeleteExpenditureCommand(ExpenditureIndex expenditure) {
        requireNonNull(expenditure);
        this.toDelete = expenditure;
    }

    /**
     * Executes the delete expenditure command
     * @param model {@code Model} which the command should operate on.
     * @return the result of the command with the success message
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.deleteExpenditure(toDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_EXPENDITURE_SUCCESS));
    }
}

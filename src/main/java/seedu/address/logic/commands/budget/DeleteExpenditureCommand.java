package seedu.address.logic.commands.budget;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.expenditureindex.ExpenditureIndex;


public class DeleteExpenditureCommand extends Command {
    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an Expenditure \n"
            + "Parameters: INDEX \n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_EXPENDITURE_SUCCESS = "Deleted Expenditure";

    private final ExpenditureIndex toDelete;

    /**
     * Creates a DeleteExpenditureCommand to delete the specified {@code expenditure}
     */
    public DeleteExpenditureCommand(ExpenditureIndex expenditure) {
        requireNonNull(expenditure);
        this.toDelete = expenditure;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.deleteExpenditure(toDelete);
        return new CommandResult(MESSAGE_DELETE_EXPENDITURE_SUCCESS);
    }
}

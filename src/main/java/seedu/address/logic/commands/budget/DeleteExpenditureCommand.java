package seedu.address.logic.commands.budget;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expenditure.Expenditure;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

public class DeleteExpenditureCommand extends Command {
    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an Expenditure. "
            + "Parameters: "
            + PREFIX_INDEX + "INDEX ";


    public static final String MESSAGE_DELETE_EXPENDITURE_SUCCESS = "Deleted Expenditure: %1$s";

    private final Index toDel;

    public DeleteExpenditureCommand(Index expenditure) {
        requireNonNull(expenditure);
        this.toDel = expenditure;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.deleteExpenditure(toDel);
        return new CommandResult(MESSAGE_DELETE_EXPENDITURE_SUCCESS);
    }
}

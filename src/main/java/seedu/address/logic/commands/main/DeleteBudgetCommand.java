package seedu.address.logic.commands.main;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

public class DeleteBudgetCommand extends Command {
    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a Budget. "
            + "Parameters: "
            + PREFIX_INDEX + "INDEX ";


    public static final String MESSAGE_DELETE_BUDGET_SUCCESS = "Deleted Budget: %1$s";

    private final int toDel;

    public DeleteBudgetCommand(int budget) {
        requireNonNull(budget);
        this.toDel = budget;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.deleteBudget(toDel);
        return new CommandResult(MESSAGE_DELETE_BUDGET_SUCCESS);
    }
}

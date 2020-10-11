package seedu.address.logic.commands.main;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;

import static java.util.Objects.requireNonNull;

public class DeleteBudgetCommand extends Command {
    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a Budget. "
            + "Parameters: "
            + "INDEX ";


    public static final String MESSAGE_DELETE_BUDGET_SUCCESS = "Deleted Budget";

    private final Index toDel;

    public DeleteBudgetCommand(Index budget) {
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

package seedu.address.logic.commands.main;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RENDERABLES;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ListBudgetCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String DESCRIPTION = "Lists all budgets.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n";

    public static final String MESSAGE_SUCCESS = "Updated list of budgets to show all entries.\n";
    public static final String EMPTY_BUDGET_MESSAGE = "You have no budgets recorded.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // sets predicate to always return true
        model.updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        int budgetSize = model.getFilteredRenderableList().size();
        if (budgetSize == 0) {
            return new CommandResult(EMPTY_BUDGET_MESSAGE);
        } else {
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }
}

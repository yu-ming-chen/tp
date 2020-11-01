package seedu.address.logic.commands.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RENDERABLES;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

public class ListExpenditureCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String DESCRIPTION = "Lists all expenditures.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n";

    public static final String MESSAGE_SUCCESS = "Updated list of expenditures to show all entries.";
    public static final String EMPTY_EXPENDITURE_MESSAGE = "You have no expenditures recorded.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        // sets predicate to always return true
        model.updateFilteredRenderableList(PREDICATE_SHOW_ALL_RENDERABLES);
        int expenditureSize = model.getFilteredRenderableList().size();
        if (expenditureSize == 0) {
            return new CommandResult(EMPTY_EXPENDITURE_MESSAGE);
        } else {
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }
}

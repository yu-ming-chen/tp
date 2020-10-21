package seedu.address.logic.commands.main;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.budget.Name;

public class FindBudgetCommand extends Command {
    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_SUCCESS =
            "List of Budgets updated to show entries that contain \'%1$s\'";

    private final Name name;

    /**
     * Creates a FindExpenditureCommand to to find expenditures matching
     * the specified {@code name}.
     * @param name the name of the expenditure to be searched.
     */
    public FindBudgetCommand(Name name) {
        requireNonNull(name);
        this.name = name;
    }

    /**
     * Executes the find expenditure command.
     * @param model {@code Model} which the command should operate on.
     * @return the result of the command with the success message.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String searchTerm = name.value;
        try {
            model.updateFilteredRenderableList(renderable -> renderable.contains(searchTerm));
            model.setSearchTerm(searchTerm);
        } catch (CommandException e) {
            return new CommandResult(e.getMessage());
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, name));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindBudgetCommand // instanceof handles nulls
                && name.equals(((FindBudgetCommand) other).name));
    }
}

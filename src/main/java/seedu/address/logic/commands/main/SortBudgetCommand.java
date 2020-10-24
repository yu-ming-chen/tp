package seedu.address.logic.commands.main;


import javafx.scene.control.TableColumn;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.sort.SortType;

/**
 * Creates a new SortBudgetCommand.
 */
public class SortBudgetCommand extends MainPageCommand {
    public static final String COMMAND_WORD = "sort";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String DESCRIPTION = "Sorts budget by name or time.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + " SORT TYPE\n"
            + "Description: " + DESCRIPTION + "\n"
            + "Parameters: TIME or NAME\n"
            + "Example: " + COMMAND_WORD + " time\n";

    public static final String MESSAGE_SUCCESS = "Sorted budgets.";

    private final SortType sortType;

    /**
     * Creates a SortBudegetCommand to to sort budgets by {@code sortType}.
     * @param sortType the type of sort.
     */
    public SortBudgetCommand(SortType sortType) {
        this.sortType = sortType;
    }
    /**
     * Executes the create budget command.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        switch (sortType) {
            case TIME: {
                model.sortBudgetsByCreatedDate();
                break;
            }
            case NAME: {
                model.sortBudgetsByName();
                break;
            }
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}

package seedu.address.logic.commands.main;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;

/**
 * Opens a budget to view and modify expenditures contained within the budget.
 */
public class OpenBudgetCommand extends MainPageCommand {

    public static final String COMMAND_WORD = "open";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Opens a Budget \n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Opened budget.";

    private final BudgetIndex toOpen;

    /**
     * Creates an OpenBudgetCommand to open the specified {@code budget}
     * @param toOpen the Index of the specific budget
     */
    public OpenBudgetCommand(BudgetIndex toOpen) {
        this.toOpen = toOpen;
    }

    /**
     * Executes the open budget command, sets the current page to the budget page.
     * @param model {@code Model} which the command should operate on.
     * @return the commmand result along with a success message
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (!model.isValidBudgetIndex(toOpen)) {
            throw new CommandException(Messages.MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        model.setPage(Page.BUDGET);
        model.setBudgetIndex(toOpen);
        model.repopulateObservableList();
        String pageName = model.getPageName(toOpen);
        model.setPageName(pageName);
        model.setIsExpenditurePage(true);
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}

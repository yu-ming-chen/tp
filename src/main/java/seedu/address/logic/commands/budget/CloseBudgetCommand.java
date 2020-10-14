package seedu.address.logic.commands.budget;

import seedu.address.logic.commands.BudgetPageCommand;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.Page;
import seedu.address.state.PageTitle;
import seedu.address.state.budgetindex.EmptyBudgetIndex;

/**
 * Closes a particular budget so the user can return to the main screen.
 */
public class CloseBudgetCommand extends BudgetPageCommand {

    public static final String COMMAND_WORD = "close";

    public static final String MESSAGE_SUCCESS = "Closed Budget";

    /**
     * Executes the close budget command and sets the current page to be the Main Page.
     * @param model {@code Model} which the command should operate on.
     * @return the result of the command with the success message.
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        //stub
        model.setPage(Page.MAIN);
        model.setBudgetIndex(new EmptyBudgetIndex());
        model.setPageName(PageTitle.MAIN_PAGE_TITLE);
        model.setIsExpenditurePage(false);
        model.repopulateObservableList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

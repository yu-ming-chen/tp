package seedu.address.logic.commands.budget;

import seedu.address.logic.commands.BudgetPageCommand;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.EmptyBudgetIndex;

public class CloseBudgetCommand extends BudgetPageCommand {

    public static final String COMMAND_WORD = "close";

    public static final String MESSAGE_SUCCESS = "Closed Budget";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        //stub
        model.setPage(Page.MAIN);
        model.setBudgetIndex(new EmptyBudgetIndex());
        model.repopulateObservableList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

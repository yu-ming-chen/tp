package seedu.address.logic.commands.main;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;

public class OpenBudgetCommand extends MainPageCommand {

    public static final String COMMAND_WORD = "open";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Opens a Budget \n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Opened Budget";

    private final BudgetIndex budgetIndex;

    public OpenBudgetCommand(BudgetIndex budgetIndex) {
        this.budgetIndex = budgetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.setPage(Page.BUDGET);
        model.setBudgetIndex(budgetIndex);
        try {
            model.repopulateObservableList();
        } catch (CommandException e) {
            // resets the page back to MAIN since the open command did not go through
            model.setPage(Page.MAIN);
            throw new CommandException(Messages.MESSAGE_INDEX_OUT_OF_BOUNDS);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

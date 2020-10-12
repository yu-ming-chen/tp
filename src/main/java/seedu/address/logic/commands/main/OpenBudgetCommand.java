package seedu.address.logic.commands.main;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;

public class OpenBudgetCommand extends MainPageCommand {

    public static final String COMMAND_WORD = "open";

    //add budget index for success message (to do String.format)
    public static final String MESSAGE_SUCCESS = "Opened Budget";

    //need attribute index in constructor
    private final BudgetIndex budgetIndex;

    public OpenBudgetCommand(BudgetIndex budgetIndex) {
        this.budgetIndex = budgetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        //stub
        //generate budget book index
        model.setPage(Page.BUDGET);
        model.setBudgetIndex(budgetIndex);
        model.repopulateObservableList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

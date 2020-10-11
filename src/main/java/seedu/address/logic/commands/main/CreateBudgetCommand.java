package seedu.address.logic.commands.main;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.MainPageCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.BudgetName;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.BudgetIndexManager;

import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class CreateBudgetCommand extends MainPageCommand {
    public static final String COMMAND_WORD = "create";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Create a Budget. "
            + "Parameters: "
            + PREFIX_NAME + "NAME ";

    //add budget index for success message (to do String.format)
    public static final String MESSAGE_SUCCESS = "Created Budget";

    //need attribute index in constructor
    private final Budget budget;

    public CreateBudgetCommand(Budget budget) {
        this.budget = budget;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        //stub
        //generate budget book index
        model.addBudget(budget);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

package seedu.address.logic.commands.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expenditure.Expenditure;

public class AddExpenditureCommand extends Command {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an Expenditure to the Budget \n"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PRICE + "PRICE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PRICE + "10 ";

    public static final String MESSAGE_SUCCESS = "New expenditure added: %1$s";

    private final Expenditure toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddExpenditureCommand(Expenditure expenditure) {
        requireNonNull(expenditure);
        toAdd = expenditure;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addExpenditure(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddExpenditureCommand // instanceof handles nulls
                && toAdd.equals(((AddExpenditureCommand) other).toAdd));
    }
}

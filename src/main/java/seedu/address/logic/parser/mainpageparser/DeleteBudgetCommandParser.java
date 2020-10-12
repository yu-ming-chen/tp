package seedu.address.logic.parser.mainpageparser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.budget.DeleteExpenditureCommand;
import seedu.address.logic.commands.main.DeleteBudgetCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;


public class DeleteBudgetCommandParser implements Parser<DeleteBudgetCommand> {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    @Override
    public DeleteBudgetCommand parse(String userInput) {
        Index budgetIndex = ParserUtil.parseBudgetIndex(userInput);
        return new DeleteBudgetCommand(budgetIndex);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

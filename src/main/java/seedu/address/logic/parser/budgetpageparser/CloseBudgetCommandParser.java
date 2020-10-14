package seedu.address.logic.parser.budgetpageparser;

import java.util.stream.Stream;

import seedu.address.logic.commands.budget.CloseBudgetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Represents a Parser that is able to parse user inputs regarding closing a budget.
 */
public class CloseBudgetCommandParser implements Parser<CloseBudgetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CloseBudgetCommand
     * and returns a CloseBudgetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CloseBudgetCommand parse(String args) {
        return new CloseBudgetCommand();
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

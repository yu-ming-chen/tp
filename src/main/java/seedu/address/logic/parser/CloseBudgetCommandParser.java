package seedu.address.logic.parser;

import seedu.address.logic.commands.budget.CloseBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

public class CloseBudgetCommandParser implements Parser<CloseBudgetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
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

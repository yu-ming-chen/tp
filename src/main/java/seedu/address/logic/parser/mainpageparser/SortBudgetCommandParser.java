package seedu.address.logic.parser.mainpageparser;

import java.util.stream.Stream;

import seedu.address.logic.commands.main.SortBudgetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Represents a Parser that is able to parse user inputs regarding sorting a budget.
 */
public class SortBudgetCommandParser implements Parser<SortBudgetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortBudgetCommand
     * and returns a SortBudgetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortBudgetCommand parse(String args) {
        return new SortBudgetCommand();
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

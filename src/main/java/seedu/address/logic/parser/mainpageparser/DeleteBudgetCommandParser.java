package seedu.address.logic.parser.mainpageparser;

import java.util.stream.Stream;

import seedu.address.logic.commands.main.DeleteBudgetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.state.budgetindex.BudgetIndex;

public class DeleteBudgetCommandParser implements Parser<DeleteBudgetCommand> {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    @Override
    public DeleteBudgetCommand parse(String userInput) throws ParseException {
        BudgetIndex budgetIndex = ParserUtil.parseBudgetIndex(userInput);
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

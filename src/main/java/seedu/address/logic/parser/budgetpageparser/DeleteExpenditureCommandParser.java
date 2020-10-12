package seedu.address.logic.parser.budgetpageparser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.budget.DeleteExpenditureCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;


public class DeleteExpenditureCommandParser implements Parser<DeleteExpenditureCommand> {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    @Override
    public DeleteExpenditureCommand parse(String userInput) {
        Index expenditureIndex = ParserUtil.parseExpenditureIndex(userInput);
        return new DeleteExpenditureCommand(expenditureIndex);
    }



    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

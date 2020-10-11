package seedu.address.logic.parser.budgetpageparser;

import seedu.address.logic.commands.budget.DeleteExpenditureCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

public class DeleteExpenditureCommandParser implements Parser<DeleteExpenditureCommand> {
    @Override
    public DeleteExpenditureCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_INDEX);

        if (!arePrefixesPresent(argMultimap, PREFIX_INDEX)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteExpenditureCommand.MESSAGE_USAGE));
        }

        int expenditureIndex = ParserUtil.parseExpenditureIndex(argMultimap.getValue(PREFIX_INDEX).get());
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

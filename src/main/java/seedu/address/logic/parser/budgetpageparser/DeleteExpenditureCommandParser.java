package seedu.address.logic.parser.budgetpageparser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.budget.DeleteExpenditureCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.stream.Stream;


public class DeleteExpenditureCommandParser implements Parser<DeleteExpenditureCommand> {
    @Override
    public DeleteExpenditureCommand parse(String args) throws ParseException {
        String[] splitter = args.split("del");
        Index expenditureIndex = ParserUtil.parseExpenditureIndex(splitter[1]);
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

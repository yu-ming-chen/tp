package seedu.address.logic.parser.mainpageparser;

import java.util.stream.Stream;

import seedu.address.logic.commands.main.OpenBudgetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.state.budgetindex.BudgetIndexManager;

public class OpenBudgetCommandParser implements Parser<OpenBudgetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the OpenBudgetCommand
     * and returns an OpenBudgetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public OpenBudgetCommand parse(String args) throws ParseException {
        //ArgumentMultimap argMultimap =
        //        ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);
        //
        //if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)
        //        || !argMultimap.getPreamble().isEmpty()) {
        //    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        //}
        //
        //ExpenditureName name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        //Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        //Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        //Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        //Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
        //
        //Person person = new Person(name, phone, email, address, tagList);

        return new OpenBudgetCommand(new BudgetIndexManager(69));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}

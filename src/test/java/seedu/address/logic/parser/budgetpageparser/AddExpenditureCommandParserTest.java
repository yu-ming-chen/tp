package seedu.address.logic.parser.budgetpageparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_MORE_THAN_THREE_TAGS;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.budget.AddExpenditureCommand;

public class AddExpenditureCommandParserTest {
    private AddExpenditureCommandParser parser = new AddExpenditureCommandParser();

    //@Test
    //public void parse_allFieldPresent_success() {
    //    assertParseSuccess(parser, " n/McMuffin p/4.50 t/breakfast t/delicious",
    //            new AddExpenditureCommand(TypicalExpenditure.getMcMuffinExpenditureWithTags()));
    //}

    //@Test
    //public void parse_allFieldExceptTagsPresent_success() {
    //    assertParseSuccess(parser, " n/McMuffin p/4.50",
    //            new AddExpenditureCommand(TypicalExpenditure.getMcMuffinExpenditureWithCurrentCreatedOn()));
    //}

    @Test
    public void parse_nameNotPresent_throwParseException() {
        assertParseFailure(parser, " p/100 t/breakfast",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddExpenditureCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_priceNotPresent_throwParseException() {
        assertParseFailure(parser, " n/McMuffin t/breakfast",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddExpenditureCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_moreThan3Tags_throwParseException() {
        assertParseFailure(parser, " n/McMuffin p/4.50 t/breakfast t/delicious t/123 t/456",
                MESSAGE_MORE_THAN_THREE_TAGS);
    }
}

package seedu.address.logic.parser.mainpageparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.main.CreateBudgetCommand;

class CreateBudgetCommandParserTest {
    private CreateBudgetCommandParser parser = new CreateBudgetCommandParser();

    //@Test
    //public void parse_allFieldPresent_success() {
    //    assertParseSuccess(parser, " n/McDonalds p/100",
    //            new CreateBudgetCommand(TypicalBudget.getEmptyMcDonaldsBudget()));
    //}

    @Test
    public void parse_nameNotPresent_throwParseException() {
        assertParseFailure(parser, " p/100",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateBudgetCommand.MESSAGE_USAGE));
    }
}

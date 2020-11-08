package seedu.address.logic.parser.mainpageparser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.main.CreateBudgetCommand;
import seedu.address.testutil.TypicalBudget;

class CreateBudgetCommandParserTest {
    private CreateBudgetCommandParser parser = new CreateBudgetCommandParser();

    @Test
    public void parse_allFieldPresent_success() {
        assertParseSuccess(parser, " n/McDonalds p/100",
                new CreateBudgetCommand(TypicalBudget.getEmptyMcDonaldsBudget()));
    }

}

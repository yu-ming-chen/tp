package seedu.address.logic.parser.budgetpageparser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.budget.AddExpenditureCommand;
import seedu.address.logic.commands.budget.CloseBudgetCommand;
import seedu.address.logic.commands.budget.DeleteExpenditureCommand;
import seedu.address.logic.commands.budget.FindExpenditureCommand;
import seedu.address.logic.commands.budget.ListExpenditureCommand;
import seedu.address.logic.parser.PageParser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Represents a Parser that is able to parse inputs occuring in the Budget Page.
 */
public class BudgetPageParser implements PageParser {
    /** Used for initial separation of command word and args. */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses a user input occurring in the Budget Page into a command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {
        case CloseBudgetCommand.COMMAND_WORD: {
            return new CloseBudgetCommandParser().parse(arguments);
        }
        case DeleteExpenditureCommand.COMMAND_WORD: {
            return new DeleteExpenditureCommandParser().parse(arguments);
        }
        case AddExpenditureCommand.COMMAND_WORD: {
            return new AddExpenditureCommandParser().parse(arguments);
        }
        case FindExpenditureCommand.COMMAND_WORD: {
            return new FindExpenditureCommandParser().parse(arguments);
        }
        case ListExpenditureCommand.COMMAND_WORD: {
            return new ListExpenditureCommand();
        }
        case HelpCommand.COMMAND_WORD: {
            return new HelpCommand();
        }
        case ExitCommand.COMMAND_WORD: {
            return new ExitCommand();
        }
        default: {
            throw new ParseException(String.format(MESSAGE_UNKNOWN_COMMAND, HelpCommand.MESSAGE_USAGE));
        }
        }
    }
}

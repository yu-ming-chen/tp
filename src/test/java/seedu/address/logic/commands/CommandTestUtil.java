package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;


public class CommandTestUtil {

    /**
     *
     * @param command
     * @param actualModel
     * @param expectedResult
     * @param expectedModel
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException e) {
            throw new AssertionError("Execution of command should not fail.", e);
        }
    }

    /**
     *
     * @param command
     * @param actualModel
     * @param expectedMessage
     * @param expectedModel
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }
}

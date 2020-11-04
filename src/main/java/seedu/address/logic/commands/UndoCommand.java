package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";
    public static final String DESCRIPTION = "Undoes the previous action.";
    public static final String SYNTAX = COMMAND_WORD;
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n";
    public static final String UNDO_MESSAGE_SUCCESS = "Undid previous action.";
    public static final String NO_UNDO_MESSAGE_SUCCESS = "No action to undo.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }
}

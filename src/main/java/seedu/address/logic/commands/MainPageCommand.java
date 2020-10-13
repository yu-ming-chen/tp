package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public abstract class MainPageCommand extends Command {

    public abstract CommandResult execute(Model model) throws CommandException;
}
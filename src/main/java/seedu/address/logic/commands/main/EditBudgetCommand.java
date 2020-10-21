package seedu.address.logic.commands.main;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INDEX_OUT_OF_BOUNDS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;

import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Renderable;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Date;
import seedu.address.model.budget.Name;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.budgetindex.BudgetIndex;




public class EditBudgetCommand extends Command {
    public static final String COMMAND_WORD = "edit";
    public static final String SYNTAX = COMMAND_WORD + " INDEX " + PREFIX_NAME + "NAME " + "(" + PREFIX_PRICE + "THRESHOLD)";
    public static final String DESCRIPTION = "Edits a budget.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Usage: " + SYNTAX + "\n"
            + "Description: " + DESCRIPTION + "\n"
            + "Parameters: INDEX\n"
            + "                            " + PREFIX_NAME + "NAME " + "(Optional)\n"
            + "                            " + PREFIX_PRICE + "THRESHOLD " + "(Optional)\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 " + PREFIX_NAME + "Books " + PREFIX_PRICE + "120\n";

    public static final String MESSAGE_SUCCESS = "Edited budget.";

    private final BudgetIndex budgetIndex;
    private final EditBudgetDescriptor editBudgetDescriptor;

    /**
     * Creates a EditBudgetCommand to edit the specified {@code budget}
     * @param index the budget index of the budget to be edited
     */
    public EditBudgetCommand(BudgetIndex index, EditBudgetDescriptor editBudgetDescriptor) {
        this.budgetIndex = index;
        this.editBudgetDescriptor = editBudgetDescriptor;
    }

    /**
     * Executes the edit budget command.
     * @param model {@code Model} which the command should operate on.
     * @return the result of the command with the success message.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Renderable> currentList = model.getFilteredRenderableList();

        if (budgetIndex.getBudgetIndex().get() >= currentList.size()) {
            throw new CommandException(MESSAGE_INDEX_OUT_OF_BOUNDS);
        }

        Budget toEdit = (Budget) currentList.get(budgetIndex.getBudgetIndex().get());
        Budget editedBudget = createEditedBudget(toEdit, editBudgetDescriptor);

        model.editBudget(toEdit, editedBudget);
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

    /**
     * Create an edited budget with the given input by the user
     * @param budgetToEdit the original budget to be edited
     * @param editBudgetDescriptor holds all the edit input from the user
     * @return the edited budget after the edit.
     */
    private static Budget createEditedBudget(Budget budgetToEdit, EditBudgetDescriptor editBudgetDescriptor) {
        Name name = editBudgetDescriptor.getName().orElse(budgetToEdit.getName());
        Date createdOn = editBudgetDescriptor.getCreatedOn().orElse(budgetToEdit.getCreatedOn());
        Optional<Threshold> threshold = editBudgetDescriptor.getThreshold().orElse(budgetToEdit.getThreshold());
        List<Expenditure> expenditures = budgetToEdit.getExpenditures();

        return new Budget(name, createdOn, threshold, expenditures);
    }

    public static class EditBudgetDescriptor {
        private Name name;
        private Date createdOn;
        private Optional<Threshold> threshold;
        private List<Expenditure> expenditures;

        public EditBudgetDescriptor() {}

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setThreshold(Optional<Threshold> threshold) {
            this.threshold = threshold;
        }

        public Optional<Optional<Threshold>> getThreshold() {
            return Optional.ofNullable(threshold);
        }

        public void setCreatedOn(Date createdOn) {
            this.createdOn = createdOn;
        }

        public Optional<Date> getCreatedOn() {
            return Optional.ofNullable(createdOn);
        }

        public Boolean isAnyFieldNull() {
            return CollectionUtil.isAnyNonNull(name, threshold, expenditures);
        }
    }
}

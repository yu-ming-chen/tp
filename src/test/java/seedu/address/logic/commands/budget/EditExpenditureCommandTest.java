/*package seedu.address.logic.commands.budget;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalBudgets.getTypicalNusave;
import static seedu.address.testutil.TypicalExpenditureIndexes.FIRST_EXPENDITURE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.budget.EditExpenditureCommand.EditExpenditureDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.Nusave;
import seedu.address.model.UserPrefs;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.testutil.EditExpenditureDescriptorBuilder;
import seedu.address.testutil.ExpenditureBuilder;

public class EditExpenditureCommandTest {

    private Model model = new ModelManager(getTypicalNusave(), new UserPrefs());

    @Test
    public void execute_editExpenditure_success() throws CommandException {
        Expenditure expenditure = new ExpenditureBuilder().build();
        model.addExpenditure(expenditure);
        EditExpenditureDescriptor descriptor = new EditExpenditureDescriptorBuilder(expenditure).build();
        EditExpenditureCommand editExpenditureCommand = new EditExpenditureCommand(FIRST_EXPENDITURE, descriptor);

        String expectedMessage = EditExpenditureCommand.MESSAGE_SUCCESS;

        Model expectedModel = new ModelManager(new Nusave(model.getNusave()), new UserPrefs());
        expectedModel.editExpenditure((Expenditure) model.getFilteredRenderableList().get(0), expenditure);

        assertCommandSuccess(editExpenditureCommand, model, expectedMessage, expectedModel);
    }

}*/

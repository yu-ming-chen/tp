package seedu.address.logic.commands;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.AppParameters;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.main.CreateBudgetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.*;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.state.Page;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.expenditureindex.ExpenditureIndex;
import seedu.address.storage.*;
import seedu.address.testutil.BudgetBuilder;
import seedu.address.testutil.TypicalBudgets;
import seedu.address.ui.Ui;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;
import static seedu.address.logic.commands.main.CreateBudgetCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalBudgets.getTypicalNusave;

public class CreateBudgetCommandTest {
    Nusave nusave = TypicalBudgets.getTypicalNusave();
    Budget budget = TypicalBudgets.MC_DONALDS;
    private Model model = new ModelManager(nusave, new UserPrefs());
    private Model expectedModel = new ModelManager();

    @Test
    public void createBudgetWithoutThreshold() {

    }

    @Test
    public void execute_create_budget_success() {

        CommandResult expectedCommandResult = new CommandResult(String.format(MESSAGE_SUCCESS, budget));
        assertEquals(expectedCommandResult, new CreateBudgetCommand(budget).execute(expectedModel));
    }
}

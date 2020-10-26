package seedu.address.ui;

import static seedu.address.model.budget.Threshold.NO_THRESHOLD_MESSAGE;

import java.util.Optional;
import java.util.logging.Logger;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.budget.Threshold;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private RenderableListPanel renderableListPanel;
    private ResultDisplay resultDisplay;
    private MainPageInfoBox mainPageInfoBox;
    private Title title;
    private HelpWindow helpWindow;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane renderableListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane mainPageInfoBoxPlaceholder;

    @FXML
    private StackPane titlePlaceholder;

    @FXML
    private StackPane statusbarPlaceholder;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());

        helpWindow = new HelpWindow();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        renderableListPanel = new RenderableListPanel(logic.getFilteredRenderableList());
        renderableListPanelPlaceholder.getChildren().add(renderableListPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        mainPageInfoBox = new MainPageInfoBox();
        bindMainPageInfoBoxToState();
        mainPageInfoBoxPlaceholder.getChildren().add(mainPageInfoBox.getRoot());

        title = new Title();
        bindTitleToState();
        titlePlaceholder.getChildren().add(title.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    private void bindTitleToState() {
        title.getTitle().textProperty().bind(Bindings.createStringBinding(() -> {
            logic.isBudgetPage(); //this expression must be called to always trigger change in title
            return logic.getPageTitle();
        }, logic.getIsBudgetPageProp()));
    }

    private void bindMainPageInfoBoxToState() {
        bindMainPageInfoBoxToPageState();
        bindMainPageInfoBoxToExpenditureState();
    }

    private void bindMainPageInfoBoxToPageState() {
        bindFirstRowTextToPageState();
        bindThirdRowTextToPageState();
    }

    private void bindMainPageInfoBoxToExpenditureState() {
        bindSecondRowTextToTotalExpenditure();
    }

    private void bindFirstRowTextToPageState() {
        mainPageInfoBox.getFirstRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            if (logic.isBudgetPage()) {
                return handleFirstRowTextIsBudgetPage();
            }
            return handleFirstRowTextIsMainPage();
        }, logic.getIsBudgetPageProp()));
    }

    private String handleFirstRowTextIsBudgetPage() {
        mainPageInfoBox.getFirstRowText().setTextAlignment(TextAlignment.LEFT);
        return "Total:";
    }

    private String handleFirstRowTextIsMainPage() {
        mainPageInfoBox.getFirstRowText().setTextAlignment(TextAlignment.CENTER);
        return MainPageInfoBox.getDefaultFirstRowText();
    }

    private void bindSecondRowTextToTotalExpenditure() {
        mainPageInfoBox.getSecondRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            String newValue = logic.getTotalExpenditureStringProp().getValue();
            if (logic.isBudgetPage()) {
                return handleSecondRowTextIsBudgetPage(newValue);
            }
            //is main page
            return handleSecondRowTextIsMainPage(newValue);
        }, logic.getTotalExpenditureStringProp()));
    }

    private String handleSecondRowTextIsBudgetPage(String value) {
        Optional<Threshold> threshold = logic.getThreshold();
        assert isFloat(value);
        String outputValue = "$ " + value;
        if (threshold.isPresent()) {
            Text secondRowText = mainPageInfoBox.getSecondRowText();
            setExpenditureColor(secondRowText, threshold, outputValue, value);
        }
        return outputValue;
    }

    private String handleSecondRowTextIsMainPage(String value) {
        setClockColor();
        return value;
    }

    private void setExpenditureColor(Text text, Optional<Threshold> threshold, String outputValue, String newValue) {
        assert threshold.isPresent();
        String thresholdValue = threshold.get().value;
        assert isFloat(newValue);
        assert isFloat(thresholdValue);

        Float newValueFloat = Float.parseFloat(newValue);
        Float thresholdValueFloat = Float.parseFloat(thresholdValue);

        if (newValueFloat > thresholdValueFloat) {
            mainPageInfoBox.getSecondRowText().setFill(Color.RED);
        } else {
            mainPageInfoBox.getSecondRowText().setFill(Color.DARKGREEN);
        }
    }

    private void setClockColor() {
        mainPageInfoBox.getSecondRowText().setFill(Color.rgb(0, 0, 0));
    }

    private boolean isFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void bindThirdRowTextToPageState() {
        mainPageInfoBox.getThirdRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            if (logic.isBudgetPage()) {
                return handleThirdRowTextIsBudgetPage();
            } else {
                return handleThirdRowTextIsMainPage();
            }
        }, logic.getIsBudgetPageProp()));
    }

    private String handleThirdRowTextIsBudgetPage() {
        mainPageInfoBox.getThirdRowText().setTextAlignment(TextAlignment.RIGHT);
        Optional<Threshold> thresholdOptional = logic.getThreshold();
        if (thresholdOptional.isEmpty()) {
            return NO_THRESHOLD_MESSAGE;
        }
        return "/" + thresholdOptional.get();
    }

    private String handleThirdRowTextIsMainPage() {
        mainPageInfoBox.getThirdRowText().setTextAlignment(TextAlignment.CENTER);
        return MainPageInfoBox.getDefaultThirdRowText();
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        primaryStage.hide();
    }

    public RenderableListPanel getRenderableListPanel() {
        return renderableListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            if (commandResult.isShowHelp()) {
                handleHelp();
            }

            if (commandResult.isExit()) {
                handleExit();
            }

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}

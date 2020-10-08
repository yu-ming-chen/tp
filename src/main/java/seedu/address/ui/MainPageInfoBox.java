package seedu.address.ui;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class MainPageInfoBox extends UiPart<Region> {

    private static final String FXML = "MainPageInfoBox.fxml";

    @javafx.fxml.FXML
    private StackPane datePane;

    @javafx.fxml.FXML
    private StackPane timePane;

    @javafx.fxml.FXML
    private StackPane greetingPane;

    @javafx.fxml.FXML
    private Text dateText;

    @javafx.fxml.FXML
    private Text timeText;

    @javafx.fxml.FXML
    private Text greetingText;

    public MainPageInfoBox() {
        super(FXML);
    }

}

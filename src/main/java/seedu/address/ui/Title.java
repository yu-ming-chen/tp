package seedu.address.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class Title extends UiPart<Region> {

    private static final String FXML = "Title.fxml";

    @javafx.fxml.FXML
    private Label title;

    public Title() {
        super(FXML);
    }

}

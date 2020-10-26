package seedu.address.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private Text firstRowText;

    @javafx.fxml.FXML
    private Text secondRowText;

    @javafx.fxml.FXML
    private Text thirdRowText;

    private String greeting;


    /**
     * Creates a new MainPageInfoBox.
     *
     */
    public MainPageInfoBox() {
        super(FXML);
        setMainPageInfoBoxText();
    }

    private void setMainPageInfoBoxText() {
        firstRowText.setText(getDefaultFirstRowText());
        setMainPageSecondRowText();
        thirdRowText.setText(getDefaultThirdRowText());
    }


    public static String getDefaultFirstRowText() {
        return new SimpleDateFormat("EEE, dd MMM").format(Calendar.getInstance().getTime());
    }

    public void setMainPageSecondRowText() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = Calendar.getInstance();
                    secondRowText.setText(new SimpleDateFormat("hh:mm a").format(cal.getTime()));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        //...
                    }
                }
            }
        };
        clock.start();
    }

    public static String getDefaultThirdRowText() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String greeting = "";
        if (hour < 12) {
            greeting = "Good Morning!";
        } else if (hour < 17) {
            greeting = "Good Afternoon!";
        } else {
            greeting = "Good Evening!";
        }
        return greeting;
    }

    public Text getFirstRowText() {
        return firstRowText;
    }

    public Text getSecondRowText() {
        return secondRowText;
    }

    public Text getThirdRowText() {
        return thirdRowText;
    }
}

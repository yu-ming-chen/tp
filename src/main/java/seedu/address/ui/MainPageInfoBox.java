package seedu.address.ui;

import java.text.DateFormat;
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
    private Text dateText;

    @javafx.fxml.FXML
    private Text timeText;

    @javafx.fxml.FXML
    private Text greetingText;

    private int minute;
    private int hour;
    private int second;
    private int date;
    private int month;
    private int year;
    private String greeting;

    /**
     * Creates a new MainPageInfoBox.
     *
     */
    public MainPageInfoBox() {
        super(FXML);
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();
                    date = cal.get(Calendar.DATE);
                    month = cal.get(Calendar.MONTH) + 1;
                    year = cal.get(Calendar.YEAR);
                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    hour = cal.get(Calendar.HOUR_OF_DAY);
                    timeText.setText(String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":"
                            + String.format("%02d", second));
                    dateText.setText(String.format("%d / %d / %d", date, month, year));
                    if (hour < 12) {
                        greeting = "Good Morning!";
                    } else if (hour >= 12 && hour < 5) {
                        greeting = "Good Afternoon!";
                    } else {
                        greeting = "Good Evening!";
                    }
                    greetingText.setText(greeting);
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

}

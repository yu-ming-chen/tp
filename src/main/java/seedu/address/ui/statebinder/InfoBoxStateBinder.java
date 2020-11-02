package seedu.address.ui.statebinder;

import static seedu.address.logic.parser.ParserUtil.isDouble;
import static seedu.address.model.budget.Threshold.NO_THRESHOLD_MESSAGE;
import static seedu.address.ui.InfoBox.DEFAULT_FONT;
import static seedu.address.ui.InfoBox.PRIMARY_FONT_SIZE;
import static seedu.address.ui.InfoBox.SECONDARY_FONT_SIZE;
import static seedu.address.ui.InfoBox.SECOND_ROW_MAX_LENGTH;

import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import seedu.address.logic.Logic;
import seedu.address.model.budget.Threshold;
import seedu.address.ui.InfoBox;

public class InfoBoxStateBinder implements StateBinder {
    private InfoBox infoBox;

    public InfoBoxStateBinder(InfoBox infoBox) {
        this.infoBox = infoBox;
    }

    @Override
    public void bind(Logic logic) {
        bindMainPageInfoBoxToPageState(logic);
        bindMainPageInfoBoxToExpenditureState(logic);
    }

    private void bindMainPageInfoBoxToPageState(Logic logic) {
        bindFirstRowTextToPageState(logic);
        bindThirdRowTextToPageState(logic);
    }

    private void bindMainPageInfoBoxToExpenditureState(Logic logic) {
        bindSecondRowTextToTotalExpenditure(logic);
    }

    private void bindFirstRowTextToPageState(Logic logic) {
        infoBox.getFirstRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            if (logic.isBudgetPage()) {
                return handleFirstRowTextIsBudgetPage();
            }
            return handleFirstRowTextIsMainPage();
        }, logic.getIsBudgetPageProp()));
    }

    private String handleFirstRowTextIsBudgetPage() {
        infoBox.getFirstRowText().setTextAlignment(TextAlignment.LEFT);
        return "Total:";
    }

    private String handleFirstRowTextIsMainPage() {
        infoBox.getFirstRowText().setTextAlignment(TextAlignment.CENTER);
        return InfoBox.getDefaultFirstRowText();
    }

    private void bindSecondRowTextToTotalExpenditure(Logic logic) {
        infoBox.getSecondRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            String newValue = logic.getTotalExpenditureStringProp().getValue();
            if (logic.isBudgetPage()) {
                return handleSecondRowTextIsBudgetPage(newValue, logic);
            }
            //is main page
            return handleSecondRowTextIsMainPage(newValue);
        }, logic.getTotalExpenditureStringProp()));
    }

    private String handleSecondRowTextIsBudgetPage(String value, Logic logic) {
        setSecondRowFontSize(value);
        Optional<Threshold> threshold = logic.getThreshold();
        assert isDouble(value);
        String outputValue = "$ " + value;
        if (threshold.isPresent()) {
            Text secondRowText = infoBox.getSecondRowText();
            setExpenditureColor(secondRowText, threshold, outputValue, value);
        }
        return outputValue;
    }

    private void setSecondRowFontSize(String value) {
        if (value.length() > SECOND_ROW_MAX_LENGTH) {
            infoBox.getSecondRowText().setFont(
                    Font.font(DEFAULT_FONT.getFamily(), SECONDARY_FONT_SIZE));
        } else {
            infoBox.getSecondRowText().setFont(
                    Font.font(DEFAULT_FONT.getFamily(), PRIMARY_FONT_SIZE));
        }
    }

    private String handleSecondRowTextIsMainPage(String value) {
        setClockColor();
        return value;
    }

    private void setExpenditureColor(Text text, Optional<Threshold> threshold, String outputValue, String newValue) {
        assert threshold.isPresent();
        String thresholdValue = threshold.get().value;
        assert isDouble(newValue);
        assert isDouble(thresholdValue);

        Double newValueDouble = Double.parseDouble(newValue);
        Double thresholdValueDouble = Double.parseDouble(thresholdValue);

        if (newValueDouble > thresholdValueDouble) {
            infoBox.getSecondRowText().setFill(Color.RED);
        } else {
            infoBox.getSecondRowText().setFill(Color.DARKGREEN);
        }
    }

    private void setClockColor() {
        infoBox.getSecondRowText().setFill(Color.rgb(0, 0, 0));
    }

    void bindThirdRowTextToPageState(Logic logic) {
        infoBox.getThirdRowText().textProperty().bind(Bindings.createStringBinding(() -> {
            if (logic.isBudgetPage()) {
                return handleThirdRowTextIsBudgetPage(logic);
            } else {
                return handleThirdRowTextIsMainPage();
            }
        }, logic.getIsBudgetPageProp()));
    }

    private String handleThirdRowTextIsBudgetPage(Logic logic) {
        infoBox.getThirdRowText().setTextAlignment(TextAlignment.RIGHT);
        Optional<Threshold> thresholdOptional = logic.getThreshold();
        if (thresholdOptional.isEmpty()) {
            return NO_THRESHOLD_MESSAGE;
        }
        return "/" + thresholdOptional.get();
    }

    private String handleThirdRowTextIsMainPage() {
        infoBox.getThirdRowText().setTextAlignment(TextAlignment.CENTER);
        return InfoBox.getDefaultThirdRowText();
    }
}

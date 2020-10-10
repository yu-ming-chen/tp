package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.budget.Budget;
import seedu.address.model.expenditure.Expenditure;

import java.util.ArrayList;
import java.util.List;

public class JsonAdaptedBudget {

    private final String title;
    private final List<JsonAdaptedExpenditure> expenditures = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableBudget} with the given expenditures.
     */
    @JsonCreator
    public JsonAdaptedBudget(@JsonProperty("title") String title, @JsonProperty("expenditures") List<JsonAdaptedExpenditure> expenditures) {
        this.title = title;
        this.expenditures.addAll(expenditures);
    }

    /**
     * Converts this budget into the model's {@code Budget} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Budget toModelType() throws IllegalValueException {
        Budget budget = new Budget(title, new ArrayList<Expenditure>());
        for (JsonAdaptedExpenditure jsonAdaptedExpenditure : expenditures) {
            Expenditure expenditure = jsonAdaptedExpenditure.toModelType();
            budget.addExpenditure(expenditure);
        }
        return budget;
    }
}

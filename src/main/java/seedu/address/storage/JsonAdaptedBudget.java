package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Name;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;

/**
 * Jackson-friendly version of {@link Budget}.
 */
public class JsonAdaptedBudget {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Budget's %s field is missing!";

    private final String name;
    private final String threshold;
    private final List<JsonAdaptedExpenditure> expenditures = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableBudget} with the given expenditures.
     */
    @JsonCreator
    public JsonAdaptedBudget(@JsonProperty("name") String name, @JsonProperty("threshold") String threshold,
                             @JsonProperty("expenditures") List<JsonAdaptedExpenditure> expenditures) {
        this.name = name;
        this.threshold = threshold;
        this.expenditures.addAll(expenditures);
    }

    /**
     * Converts a given {@code Budget} into this class for Jackson use.
     */
    public JsonAdaptedBudget(Budget source) {
        name = source.getName().value;
        threshold = source.getThreshold().orElse(new Threshold("")).value;
        expenditures.addAll(source.getExpenditures().stream()
                .map(JsonAdaptedExpenditure::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted budget object into the model's {@code Budget} object.
     * @return the Budget object converted from Json format.
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Budget toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }

        if (!Name.isValid(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name budgetName = new Name(name);

        if (threshold == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Threshold.class.getSimpleName()));
        }
        if (!Threshold.isValid(threshold)) {
            throw new IllegalValueException(Threshold.MESSAGE_CONSTRAINTS);
        }
        final Optional<Threshold> budgetThreshold = Optional.of(new Threshold(threshold));

        Budget budget = new Budget(budgetName, budgetThreshold, new ArrayList<Expenditure>());

        // converts each jsonAdaptedExpenditure into an Expenditure and adds them into the budget

        for (JsonAdaptedExpenditure jsonAdaptedExpenditure : expenditures) {
            Expenditure expenditure = jsonAdaptedExpenditure.toModelType();
            budget.addExpenditure(expenditure);
        }

        return budget;
    }
}

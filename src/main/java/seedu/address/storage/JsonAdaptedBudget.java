package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Name;
import seedu.address.model.expenditure.Expenditure;

public class JsonAdaptedBudget {

    private final String budgetName;
    private final List<JsonAdaptedExpenditure> expenditures = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableBudget} with the given expenditures.
     */
    @JsonCreator
    public JsonAdaptedBudget(@JsonProperty("budgetName") String budgetName,
                             @JsonProperty("expenditures") List<JsonAdaptedExpenditure> expenditures) {
        this.budgetName = budgetName;
        this.expenditures.addAll(expenditures);
    }

    /**
     * Converts a given {@code Budget} into this class for Jackson use.
     */
    public JsonAdaptedBudget(Budget source) {
        budgetName = source.getName();
        expenditures.addAll(source.getExpenditures().stream()
                .map(JsonAdaptedExpenditure::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this budget into the model's {@code Budget} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Budget toModelType() throws IllegalValueException {
        Budget budget = new Budget(new Name(budgetName), new ArrayList<Expenditure>());
        for (JsonAdaptedExpenditure jsonAdaptedExpenditure : expenditures) {
            Expenditure expenditure = jsonAdaptedExpenditure.toModelType();
            budget.addExpenditure(expenditure);
        }
        return budget;
    }
}

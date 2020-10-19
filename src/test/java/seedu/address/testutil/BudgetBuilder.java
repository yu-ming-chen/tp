package seedu.address.testutil;

import java.util.List;
import java.util.Optional;

import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Name;
import seedu.address.model.budget.Threshold;
import seedu.address.model.expenditure.Expenditure;

public class BudgetBuilder {
    public static final String DEFAULT_NAME = "BREAKFAST";
    public static final Optional<Threshold> DEFAULT_THRESHOLD = Optional.of(new Threshold("100"));
    public static final List<Expenditure> DEFAULT_EXPENDITURES = TypicalExpenditures.getTypicalExpenditures();

    private Name name;
    private Optional<Threshold> threshold;
    private List<Expenditure> expenditures;

    /**
     * Creates a {@code BudgetBuilder} with a threshold using the default details.
     */
    public BudgetBuilder() {
        name = new Name(DEFAULT_NAME);
        threshold = DEFAULT_THRESHOLD;
        expenditures = DEFAULT_EXPENDITURES;
    }

    /**
     * Creates a {@code BudgetBuilder} with the data of {@code budgetToCopy}.
     */
    public BudgetBuilder(Budget budgetToCopy) {
        name = budgetToCopy.getName();
        threshold = budgetToCopy.getThreshold();
        expenditures = budgetToCopy.getExpenditures();
    }

    /**
     * Creates a {@code BudgetBuilder} without a threshold using the default details.
     */
    public static BudgetBuilder withoutThreshold() {
        return new BudgetBuilder().withThreshold(Optional.empty());
    }

    /**
     * Sets the {@code name} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code threshold} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withThreshold(Optional<Threshold> threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * Sets the {@code expenditures} of the {@code Budget} that we are building.
     */
    public BudgetBuilder withExpenditures(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
        return this;
    }

    public Budget build() {
        return new Budget(name, threshold, expenditures);
    }
}

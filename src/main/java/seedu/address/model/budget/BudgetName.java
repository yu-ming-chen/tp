package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.expenditure.ExpenditureName;

public class BudgetName {
    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank.";

    /*
     * The first character of the name must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Constructs a {@code BudgetName}.
     *
     * @param value A valid title.
     */
    public BudgetName(String value) {
        requireNonNull(value);
        checkArgument(isValidBudgetName(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidBudgetName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenditureName // instanceof handles nulls
                && value.equals(((ExpenditureName) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

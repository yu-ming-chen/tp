package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.logic.parser.ParserUtil.isValidDouble;

import java.util.Optional;

public class Threshold {
    public static final String MESSAGE_CONSTRAINTS =
            "Thresholds can be empty or contain only numbers, and it can have at most 2 decimal places.";
    public static final String NON_ZERO_CONSTRAINTS =
            "Sorry! Thresholds cannot be 0! It can only exist in the range between 0 and $1,000,000, exclusive.";
    public static final String EXCEEDED_VALUE_ERROR =
            "Sorry! Thresholds cannot exceed $1,000,000. "
                    + "It can only exist in the range between 0 and $1,000,000, exclusive.";
    public static final String VALIDATION_REGEX = "^$|[0-9]+(\\.[0-9]?[0-9])?$";
    public static final String NO_THRESHOLD_MESSAGE = "";
    public static final double MAX_VALUE = 999999.99;
    public final String value;

    /**
     * Constructs a {@code Threshold}.
     */
    public Threshold(String threshold) {
        requireNonNull(threshold);
        checkArgument(isValid(threshold), MESSAGE_CONSTRAINTS);
        value = threshold;
    }

    /**
     * Returns true if a given string is a valid threshold.
     */
    public static boolean isValid(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public static boolean isZero(String test) {
        return Double.parseDouble(test) == 0;
    }

    public static boolean isExceededValue(String test) {
        return Double.parseDouble(test) > Threshold.MAX_VALUE && isValidDouble(test);
    }

    /**
     * Converts {@code Threshold} into an {@code Optional<Threshold>}.
     */
    public Optional<Threshold> toOptional() {
        if (value.isBlank()) {
            return Optional.empty();
        } else {
            return Optional.of(this);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Threshold // instanceof handles nulls
                && value.equals(((Threshold) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

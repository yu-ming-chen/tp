package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;



public class Date implements Comparable<Date> {
    public static final String MESSAGE_CONSTRAINTS = "Dates should be able to be parsed by LocalDate.";

    public final String value;

    /**
     * Constructs a {@code Date}.
     *
     * @param value A valid date.
     */
    public Date(String value) {
        requireNonNull(value);
        checkArgument(isValid(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValid(String test) {
        try {
            LocalDate.parse(test);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && value.equals(((Date) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Date date) {
        return LocalDate.parse(value).compareTo(LocalDate.parse(date.value));
    }
}

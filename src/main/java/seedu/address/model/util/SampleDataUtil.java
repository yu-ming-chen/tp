package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Nusave;
import seedu.address.model.ReadOnlyNusave;
import seedu.address.model.budget.Budget;
import seedu.address.model.budget.Name;
import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.expenditure.Price;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Budget[] getSampleBudgets() {
        return new Budget[] {
            new Budget(new Name("Test Name 1"), Arrays.asList(getSampleExpenditures())),
            new Budget(new Name("Test Name 2"), Arrays.asList(getSampleExpenditures()))
        };
    }

    public static Expenditure[] getSampleExpenditures() {
        return new Expenditure[]{
            new Expenditure(new seedu.address.model.expenditure.Name("Shirt"),
                    new Price("85.50"), new Date("2020-10-10"), getTagSet("Apparel", "White")),
            new Expenditure(new seedu.address.model.expenditure.Name("Pants"),
                    new Price("100.50"), new Date("2020-10-10"), getTagSet("Apparel", "Black"))
        };
    }

    public static ReadOnlyNusave getSampleNusave() {
        Nusave sampleNusave = new Nusave();
        for (Budget budget : getSampleBudgets()) {
            sampleNusave.addBudget(budget);
        }
        return sampleNusave;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }
}

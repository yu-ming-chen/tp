package seedu.address.model.expenditure;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.tag.Tag;

public class Expenditure {
    private final Name name;
    private final Price price;
    private final Date createdOn;
    private final Set<Tag> tags = new HashSet<>();

    /**
     *
     * @param name
     * @param price
     * @param createdOn
     * @param tags
     */
    public Expenditure(Name name, Price price, Date createdOn, Set<Tag> tags) {
        requireAllNonNull(name, price, createdOn, tags);
        this.name = name;
        this.price = price;
        this.createdOn = createdOn;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Expenditure)) {
            return false;
        }

        Expenditure otherExpenditure = (Expenditure) other;
        return otherExpenditure.getName().equals(getName());
    }
}

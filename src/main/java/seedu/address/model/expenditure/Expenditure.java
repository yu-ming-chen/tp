package seedu.address.model.expenditure;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.Renderable;
import seedu.address.model.tag.Tag;

public class Expenditure implements Renderable {
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

    public java.util.Date getFormattedCreatedOn() {
        return createdOn.getFormattedCreatedOn();
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
        return otherExpenditure.getName().equals(getName())
                && otherExpenditure.getPrice().equals(getPrice())
                && otherExpenditure.getCreatedOn().equals(getCreatedOn())
                && otherExpenditure.getTags().equals(getTags());
    }

    /**
     * Returns true if both expenditure of the same name have at the created on field that is the same.
     * This defines a weaker notion of equality between two expenditures.
     */
    public boolean isSameExpenditure(Expenditure otherExpenditure) {
        if (otherExpenditure == this) {
            return true;
        }

        return otherExpenditure != null
                && otherExpenditure.getName().equals(getName())
                && otherExpenditure.getPrice().equals(getPrice())
                && otherExpenditure.getCreatedOn().equals(getCreatedOn());
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean contains(String str) {
        String nameLowerCase = name.value.toLowerCase();
        return nameLowerCase.contains(str.toLowerCase());
    }
}

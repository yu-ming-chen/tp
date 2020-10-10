package seedu.address.model.expenditure;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Expenditure {
    private final String title;
    private final int price;
    private final Date createdOn;
    private final Set<Tag> tags = new HashSet<>();

    public Expenditure(String title, int price, Date createdOn, Set<Tag> tags) {
        requireAllNonNull(title, price, createdOn, tags);
        this.title = title;
        this.price = price;
        this.createdOn = createdOn;
        this.tags.addAll(tags);
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
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
        return otherExpenditure.getTitle().equals(getTitle());
//                && otherExpenditure.getPrice().equals(getPhone())
//                && otherPerson.getEmail().equals(getEmail())
//                && otherPerson.getAddress().equals(getAddress())
//                && otherPerson.getTags().equals(getTags());
    }
}

package seedu.address.model.expenditure;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.Renderable;
import seedu.address.model.tag.Tag;

public class Expenditure implements Renderable {
    private final ExpenditureName expenditureName;
    private final Price price;
    private final Date createdOn;
    private final Set<Tag> tags = new HashSet<>();

    /**
     *
     * @param expenditureName
     * @param price
     * @param createdOn
     * @param tags
     */
    public Expenditure(ExpenditureName expenditureName, Price price, Date createdOn, Set<Tag> tags) {
        requireAllNonNull(expenditureName, price, createdOn, tags);
        this.expenditureName = expenditureName;
        this.price = price;
        this.createdOn = createdOn;
        this.tags.addAll(tags);
    }

    public ExpenditureName getExpenditureName() {
        return expenditureName;
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
        return otherExpenditure.getExpenditureName().equals(getExpenditureName());
    }
}

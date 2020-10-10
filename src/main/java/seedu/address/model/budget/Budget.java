package seedu.address.model.budget;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Date;
import java.util.List;

import seedu.address.model.expenditure.Expenditure;

public class Budget {
    private final String title;
    private final int limit;
    private final Date createdOn;
    private final List<Expenditure> expenditures;

    /**
     *
     * @param title
     * @param limit
     * @param createdOn
     * @param expenditures
     */
    public Budget(String title, int limit, Date createdOn, List<Expenditure> expenditures) {
        requireAllNonNull(title, expenditures, limit, createdOn);
        this.title = title;
        this.limit = limit;
        this.createdOn = createdOn;
        this.expenditures = expenditures;
    }

    public String getTitle() {
        return title;
    }

    public int getLimit() {
        return limit;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

}

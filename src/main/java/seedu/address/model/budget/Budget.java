package seedu.address.model.budget;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.address.model.expenditure.Expenditure;

public class Budget {
    private final String title;
    private final List<Expenditure> expenditures;

    /**
     *
     * @param title
     * @param expenditures
     */
    public Budget(String title, List<Expenditure> expenditures) {
        requireAllNonNull(title, expenditures);
        this.title = title;
        this.expenditures = expenditures;
    }

    public String getTitle() {
        return title;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }
}

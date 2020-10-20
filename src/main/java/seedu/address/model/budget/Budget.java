package seedu.address.model.budget;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Optional;

import seedu.address.model.Renderable;
import seedu.address.model.expenditure.Expenditure;

public class Budget implements Renderable {
    private final Name name;
    private final Date createdOn;
    private final Optional<Threshold> threshold;
    private final List<Expenditure> expenditures;

    /**
     *
     * @param name
     * @param expenditures
     */
    public Budget(Name name, Date date, List<Expenditure> expenditures) {
        requireAllNonNull(name, expenditures);
        this.name = name;
        this.createdOn = date;
        this.expenditures = expenditures;
        this.threshold = Optional.empty();
    }

    /**
     *
     * @param name
     * @param threshold
     * @param expenditures
     */
    public Budget(Name name, Date date, Optional<Threshold> threshold, List<Expenditure> expenditures) {
        requireAllNonNull(name, expenditures, threshold);
        this.name = name;
        this.createdOn = date;
        this.threshold = threshold;
        this.expenditures = expenditures;
    }

    public Name getName() {
        return name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Optional<Threshold> getThreshold() {
        return threshold;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }

    public void editExpenditure(Expenditure oldExpenditure, Expenditure editedExpenditure) {
        int index = expenditures.indexOf(oldExpenditure);
        expenditures.set(index, editedExpenditure);
    }

    public void deleteExpenditure(int expenditure) {
        expenditures.remove(expenditure);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Budget)) {
            return false;
        }

        Budget otherBudget = (Budget) other;
        return otherBudget.getName().equals(getName())
                && otherBudget.getThreshold().equals(getThreshold())
                && otherBudget.getExpenditures().equals(getExpenditures());
    }

    /**
     * Returns true if {@code Name} contains the given {@code string}.
     */
    public boolean contains(String string) { //Todo: Change method name to be more descriptive.
        String nameLowerCase = name.value.toLowerCase(); //Todo: Tell, don't ask.
        return nameLowerCase.contains(string.toLowerCase());
    }
}

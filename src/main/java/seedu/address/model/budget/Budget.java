package seedu.address.model.budget;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Optional;

import seedu.address.model.Renderable;
import seedu.address.model.expenditure.Expenditure;

public class Budget implements Renderable {
    private final Name name;
    private final Optional<Threshold> threshold;
    private final List<Expenditure> expenditures;

    /**
     *
     * @param name
     * @param expenditures
     */
    public Budget(Name name, List<Expenditure> expenditures) {
        requireAllNonNull(name, expenditures);
        this.name = name;
        this.expenditures = expenditures;
        this.threshold = Optional.empty();
    }

    /**
     *
     * @param name
     * @param threshold
     * @param expenditures
     */
    public Budget(Name name, Threshold threshold, List<Expenditure> expenditures) {
        requireAllNonNull(name, expenditures, threshold);
        this.name = name;
        this.threshold = Optional.of(threshold);
        this.expenditures = expenditures;
    }

    public String getName() {
        return name.value;
    }

    public String getThreshold() {
        return threshold.orElse(new Threshold("")).value;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }

    public void deleteExpenditure(int expenditure) {
        expenditures.remove(expenditure);
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

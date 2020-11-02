package seedu.address.model.expenditure;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.sort.SortExpenditureByCreateDate;
import seedu.address.model.sort.SortExpendituresByName;

public class ExpenditureList {
    private final List<Expenditure> expenditures;

    public ExpenditureList() {
        this.expenditures = new ArrayList<>();
    }
    public ExpenditureList(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
    }
    /**
     * Adds a expenditure to the list of budgets.
     */
    public void add(Expenditure toAdd) {
        requireNonNull(toAdd);
        expenditures.add(0, toAdd);
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }
    public List<Expenditure> getExpendituresList() {
        return expenditures;
    }
    public int getExpenditureSize() {
        return expenditures.size();
    }

    public String getTotalExpenditure() {
        Double resultDouble = 0.0;
        for (Expenditure e : expenditures) {
            Price price = e.getPrice();
            String value = price.value;
            resultDouble += Double.parseDouble(value);
        }
        return String.format("%.2f", Double.valueOf(resultDouble));
    }

    /**
     * Edits an expenditure within the expenditures by replacing the {code: oldExpenditure}
     * with a {code: newExpenditure}.
     * @param oldExpenditure
     * @param editedExpenditure
     */
    public void editExpenditure(Expenditure oldExpenditure, Expenditure editedExpenditure) {
        int index = expenditures.indexOf(oldExpenditure);
        expenditures.set(index, editedExpenditure);
    }

    public void sortExpenditureListByName() {
        expenditures.sort(new SortExpendituresByName());
    }
    public void sortExpenditureListByCreateDate() {
        this.expenditures.sort(new SortExpenditureByCreateDate());
    }
}

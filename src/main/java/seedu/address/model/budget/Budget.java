package seedu.address.model.budget;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.address.model.expenditure.Expenditure;

public class Budget {
    private final BudgetName budgetName;
    private final List<Expenditure> expenditures;

    /**
     *
     * @param budgetName
     * @param expenditures
     */
    public Budget(BudgetName budgetName, List<Expenditure> expenditures) {
        requireAllNonNull(budgetName, expenditures);
        this.budgetName = budgetName;
        this.expenditures = expenditures;
    }

    public String getName() {
        return budgetName.value;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditures.add(expenditure);
    }
}

package seedu.address.state.expenditureindex;

import java.util.Optional;

public class ExpenditureIndexManager implements ExpenditureIndex {
    private int expenditureIndex;

    public ExpenditureIndexManager(int budgetIndex) {
        this.expenditureIndex = budgetIndex;
    }

    @Override
    public Optional<Integer> getExpenditureIndex() {
        return Optional.of(this.expenditureIndex);
    }

    @Override
    public void setIndex(int index) {
        this.expenditureIndex = index;
    }
}

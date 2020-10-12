package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Renderable;
import seedu.address.model.budget.Budget;
import seedu.address.model.expenditure.Expenditure;

/**
 * Panel containing the list of persons.
 */
public class BudgetListPanel extends UiPart<Region> {
    private static final String FXML = "BudgetListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BudgetListPanel.class);

    @FXML
    private ListView<Renderable> budgetListView;

    /**
     * Creates a {@code BudgetListPanel} with the given {@code ObservableList}.
     */
    public BudgetListPanel(ObservableList<Renderable> renderableList) {
        super(FXML);
        budgetListView.setItems(renderableList);
        budgetListView.setCellFactory(listView -> new RenderableListViewCell());
    }

    class RenderableListViewCell extends ListCell<Renderable> {
        @Override
        protected void updateItem(Renderable renderable, boolean empty) {
            super.updateItem(renderable, empty);

            if (empty || renderable == null) {
                setGraphic(null);
                setText(null);
            } else if (renderable instanceof Budget) {
                setGraphic(new BudgetCard((Budget) renderable, getIndex() + 1).getRoot());
            } else if (renderable instanceof Expenditure) {
                setGraphic(new ExpenditureCard((Expenditure) renderable, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class BudgetListViewCell extends ListCell<Budget> {
        @Override
        protected void updateItem(Budget budget, boolean empty) {
            super.updateItem(budget, empty);

            if (empty || budget == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new BudgetCard(budget, getIndex() + 1).getRoot());
            }
        }
    }

}

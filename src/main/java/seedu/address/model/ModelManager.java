package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.model.budget.Budget;
import seedu.address.model.expenditure.Expenditure;
import seedu.address.model.person.Person;
import seedu.address.state.Page;
import seedu.address.state.StateManager;
import seedu.address.state.budgetindex.BudgetIndex;
import seedu.address.state.budgetindex.EmptyBudgetIndex;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final Nusave nusave;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private final StateManager stateManager;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyNusave nusave, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(nusave, userPrefs);

        logger.fine("Initializing with address book: " + nusave + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook();
        this.nusave = new Nusave(nusave);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
        this.stateManager = new StateManager(new EmptyBudgetIndex(), Page.MAIN);
    }

    public ModelManager() {
        this(new Nusave(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        addressBook.setPerson(target, editedPerson);
    }

    //=========== Nusave =======

    @Override
    public ReadOnlyNusave getNusave() {
        return nusave;
    }

    @Override
    public void addBudget(Budget budget) {
        requireNonNull(budget);

        nusave.addBudget(budget);
    }

    @Override
    public void deleteBudget(Index budget) {
        requireNonNull(budget);

        nusave.deleteBudget(budget.getZeroBased());
    }

    @Override
    public void deleteExpenditure(Index expenditure) {
        requireNonNull(expenditure);

        nusave.deleteExpenditure(expenditure.getZeroBased(), this.stateManager.getBudgetIndex());
    }

    //=========== StateManager ================================================================================

    @Override
    public boolean isMain() {
        return this.stateManager.isMain();
    }

    @Override
    public boolean isBudget() {
        return this.stateManager.isBudget();
    }

    @Override
    public Optional<Integer> getBudgetIndex() {
        return this.stateManager.getBudgetIndex();
    }

    @Override
    public Page getPage() {
        return this.stateManager.getPage();
    }

    @Override
    public void setBudgetIndex(BudgetIndex index) {
        this.stateManager.setBudgetIndex(index);
    }

    @Override
    public void setPage(Page page) {
        this.stateManager.setPage(page);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons);
    }

}

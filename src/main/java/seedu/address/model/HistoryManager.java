package seedu.address.model;

public class HistoryManager<T> implements History<T> {
    private Node<T> history;

    public HistoryManager(T head) {
        history = new Node<>(head);
    }

    @Override
    public boolean hasHistory() {
        return history.hasPrevious();
    }

    @Override
    public T getHistory() {
        rollBack();
        T history = this.history.getValue();
        return history;
    }

    @Override
    public boolean hasFuture() {
        return history.hasNext();
    }

    @Override
    public T getFuture() {
        rollForward();
        return history.getValue();
    }

    @Override
    public void save(T toSave) {
        history.add(new Node<>(toSave));
        rollForward();
    }

    private void rollBack() {
        history = history.getPrevious();
    }
    
    private void rollForward() {
        history = history.getNext();
    }
}

package seedu.address.model.history;

public class HistoryManager<T> implements History<T> {
    private Node<T> history;

    public HistoryManager(T head) {
        history = new Node<>(head);
    }

    @Override
    public boolean hasHistory() {
        assert history != null;
        return history.hasPrevious();
    }

    @Override
    public T getHistory() {
        assert hasHistory();
        rollBack();
        T history = this.history.getValue();
        return history;
    }

    @Override
    public boolean hasFuture() {
        assert history != null;
        return history.hasNext();
    }

    @Override
    public T getFuture() {
        assert hasFuture();
        rollForward();
        return history.getValue();
    }

    @Override
    public void save(T toSave) {
        assert history != null;
        history.add(new Node<>(toSave));
        rollForward();
    }

    private void rollBack() {
        assert history.hasPrevious();
        history = history.getPrevious();
    }

    private void rollForward() {
        assert history.hasNext();
        history = history.getNext();
    }
}

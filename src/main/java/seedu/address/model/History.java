package seedu.address.model;

public interface History<T> {
    boolean hasHistory();
    T getHistory();
    boolean hasFuture();
    T getFuture();
    void save(T history);
}

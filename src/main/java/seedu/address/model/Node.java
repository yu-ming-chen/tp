package seedu.address.model;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;
    
    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    
    public T getValue() {
        return value;
    }

    public void add(Node<T> toAdd) {
        toAdd.setPrevious(this);
        setNext(toAdd);
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }
    
    public boolean hasNext() {
        return next != null;
    }
    
    public boolean hasPrevious() {
        return previous != null;
    }

    private void setNext(Node<T> next) {
        this.next = next;
    }
    
    private void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}

package ru.manik.calculator.model;

//Node class to use in Linked Stack
//item with priority

public class LinkNode<T> {
    private T item;
    private int priority;

    private LinkNode<T> next;

    public LinkNode(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public LinkNode(T item) {
        this(item, 0);
    }

    public int getPriority() {
        return priority;
    }

    public T getItem() {
        return item;
    }

    public void setNext(LinkNode<T> linkNode) {
        this.next = linkNode;
    }

    public LinkNode<T> getNext() {
        return next;
    }
}

package ru.manik.calculator.model;

//Linked Stack to adding math symbols with priority

public class ListSignStack<T> {

    private LinkNode<T> first;
    private int size;

    public ListSignStack() {
        size = 0;
        first = null;
    }

    public void push(T item) {
        LinkNode<T> linkNode = new LinkNode<>(item);
        push(linkNode);
    }

    public  void push(T item, int priority) {
        LinkNode<T> linkNode = new LinkNode<>(item, priority);
        push(linkNode);
    }

    public void push(LinkNode<T> linkNode) {
        if (size == 0) {
            first = linkNode;
        } else {
            linkNode.setNext(first);
            first = linkNode;
        }
        size++;
    }

    public LinkNode<T> pop() {
        LinkNode<T> linkNode = first;
        first = first.getNext();
        size--;
        return linkNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}

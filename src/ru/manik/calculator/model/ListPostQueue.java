package ru.manik.calculator.model;

//Linked Queue to help parse string to create infix array(ParseStringToInfix.class)
// and help to created postfix (InfixToPostfix.class)

public class ListPostQueue<T> {

    class Link<U> {
        U item;
        Link<U> next;
        Link<U> prev;
    }

    private Integer size;
    private Link<T> first;
    private Link<T> last;

    public ListPostQueue() {
        size = 0;
    }

    public void push(T item) {
        Link<T> link = new Link<>();
        link.item = item;
        push(link);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T pop() {
        Link<T> link = last;
        last = last.prev;
        size--;
        return link.item;
    }

    private void push(Link<T> link) {
        if (this.size == 0) {
            first = link;
            last = link;
        } else {
            link.next = first;
            first.prev = link;
            link.prev = null;
            first = link;
        }
    }


}

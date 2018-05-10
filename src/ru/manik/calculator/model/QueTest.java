package ru.manik.calculator.model;

public class QueTest {

    public static void main(String[] args) {
        ListPostQueue<String> queue = new ListPostQueue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}

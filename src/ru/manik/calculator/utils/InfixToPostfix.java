package ru.manik.calculator.utils;

import ru.manik.calculator.model.LinkNode;
import ru.manik.calculator.model.ListPostQueue;
import ru.manik.calculator.model.ListSignStack;


//Create postfix to calculate

public class InfixToPostfix {

    private ListSignStack<String> stack = new ListSignStack<>();
    private ListPostQueue<String> queue = new ListPostQueue<>();

    public void inToPos(String[] args) {


        for (String arg : args) {
            try {
                Integer.parseInt(arg); //if arg is digit
                queue.push(arg);        //add to queue
            } catch (NumberFormatException e) { //else
                if (arg.length() == 1) { //if it sign
                    switch (arg) {
                        case "+":
                        case "-":
                            getOperator(arg, 1); //check previous operator by priority
                            break;
                        case "*":
                        case "/":
                            getOperator(arg, 2);
                            break;
                        case "(":
                            getOperator(arg, 3);
                            break;
                        case ")":
                            popPrintStackToQueue(); //add to queue all operators to the "("
                            break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            queue.push(stack.pop().getItem());
        }
    }

    //return all signs from stack to queue
    private void popPrintStackToQueue() {
        while (!stack.isEmpty()) {
            String sign;
            sign = stack.pop().getItem();
            if (sign.equalsIgnoreCase("(")) {
                return;
            } else {
                queue.push(sign);
            }
        }
    }

    /**check operator by priority
    //if stack isEmpty — push operator to stack
    //else if new operator less or equal previous
    //add previous operator to queue and push new operator to stack
    //else push new operator to stack
     */
    private void getOperator(String arg, int priority) {
        if(!stack.isEmpty()) {
            LinkNode<String> top = stack.pop();
            if (top.getPriority() < priority) {
                stack.push(top);
                stack.push(arg, priority);
            } else if (top.getItem().equalsIgnoreCase("(")){
                stack.push(top);
                stack.push(arg, priority);
            } else {
                queue.push(top.getItem());
                stack.push(arg,priority);
            }
        } else {
            stack.push(arg, priority);
        }
    }

    /**
     * return the postfix expression queue
     * @return
     */

    public ListPostQueue<String> getQueue() {
        return queue;
    }


    //testing system, I know it is not a good practice
    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        ParseStringToInfix string = new ParseStringToInfix();

        infixToPostfix.inToPos(string.infixStringToArray("1+2-3"));


    }
}

package ru.manik.calculator.utils;

import ru.manik.calculator.model.ListSignStack;

public class Calculate {


    //take the string and return result of mathematical expression
    public static int calc(String string) {

        InfixToPostfix infixToPostfix = new InfixToPostfix(); //create class to save postfix expression
        infixToPostfix.inToPos(ParseStringToInfix.infixStringToArray(string)); //create postfix expression form string

        ListSignStack<Integer> stack = new ListSignStack<>(); //create stack to save intermediate instance

        int result = 0;

        while (!infixToPostfix.getQueue().isEmpty()) {
            String top = infixToPostfix.getQueue().pop();
            try {
                int numb = Integer.parseInt(top);
                stack.push(numb);
            } catch (NumberFormatException e) {
                int numb1 = stack.pop().getItem();
                int numb2;
                if (stack.getSize() >= 1) {
                    numb2 = stack.pop().getItem();
                } else {
                    numb2 = 0;
                }

                switch (top) {
                    case "+":
                        result = numb2 + numb1;
                        break;
                    case "-":
                        result = numb2 - numb1;
                        break;
                    case "*":
                        result = numb2 * numb1;
                        break;
                    case "/":
                        result = numb2 / numb1;
                        break;
                }
                stack.push(result);
            }
        }
        if (stack.isEmpty()) {
            System.out.print("Try again or type 'exit': ");
            return 0;
        }
        return stack.pop().getItem();
    }
    //testing system, I know it is not a good practice
    public static void main(String[] args) {
        System.out.println(calc("3/2-1+(4*3)"));
    }

}

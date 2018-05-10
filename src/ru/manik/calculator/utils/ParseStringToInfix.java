package ru.manik.calculator.utils;

import ru.manik.calculator.model.ListPostQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Parse string to infix array by using self-created date structures
public class ParseStringToInfix {

    private static List<Character> sign = new ArrayList<>(Arrays.asList('+', '-', '*', '/', '(', ')',' '));

    public static String[] infixStringToArray(String string) {

        List<String> list = new ArrayList<>();
        ListPostQueue<Character> numberQueue = new ListPostQueue<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(ch >= '0' && ch <= '9') {
                numberQueue.push(ch);
            } else if (sign.contains(ch)){
                if (!numberQueue.isEmpty()) {
                   StringBuilder sb = new StringBuilder();
                   while (!numberQueue.isEmpty()){
                       sb.append(numberQueue.pop());
                   }
                   list.add(sb.toString());
                   if (ch != ' ') {
                       list.add(String.valueOf(ch));
                   }
                } else {
                    list.add(String.valueOf(ch));
                }
            } else {
                System.out.println("Sorry, but you need to use digit ore sign like '+,-,*,/, (,)'");
                return new String[0];
            }
        }

        if (!numberQueue.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            while (!numberQueue.isEmpty()) {
                stringBuilder.append(numberQueue.pop());
            }
            list.add(String.valueOf(stringBuilder.toString()));
        }

        return list.toArray(new String[list.size()]);
    }

    //testing system, I know it is not a good practice
    public static void main(String[] args) {
        for(String s : infixStringToArray("1+2")) {
            System.out.println(s);
        }

    }
}

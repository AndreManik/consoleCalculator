package ru.manik.calculator;

import ru.manik.calculator.utils.Calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String example = "Enter the example: ";
            System.out.println(example);
            while (!(example = reader.readLine()).equalsIgnoreCase("exit")) {
                System.out.println(Calculate.calc(example));
            }
            System.out.println("Good luck! See you later!");
        } catch (IOException e) {
            System.out.println("Sorry");
        }
    }
}

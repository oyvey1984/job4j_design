package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        Scanner input = new Scanner(System.in);
        while (startAt < 100) {
            String expected = fizzBuzz(startAt);
            System.out.println(expected);
            startAt++;

            String userInput = input.nextLine();
            String correctAnswer = fizzBuzz(startAt);

            if (!correctAnswer.equals(userInput)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 1;
                continue;
            }
            startAt++;
        }
    }

    private static String fizzBuzz(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        } else {
             return String.valueOf(number);
        }
    }
}

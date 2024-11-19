package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());

            for (String line : lines) {
                try {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) {
                        System.out.println(number + " - чётное число");
                    } else {
                        System.out.println(number + " - нечётное число");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: '" + line + "' не является числом.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
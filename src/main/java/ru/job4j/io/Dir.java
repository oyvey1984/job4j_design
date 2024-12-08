package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\projects\\job4j_design\\data");

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.getAbsoluteFile()));
        }
        
        File[] files = file.listFiles();
            if (files == null) {
                throw new NullPointerException("Ошибка: метод listFiles() вернул null");
            }
        for (File subfile : files) {
            if (subfile.isFile()) {
                System.out.printf("Файл: %s%nРазмер файла: %s%n%n",
                        subfile.getName(), subfile.length());
            }
        }
    }
}

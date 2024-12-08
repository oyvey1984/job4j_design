package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\projects");

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.getAbsoluteFile()));
        }
        System.out.printf("Общий объем пространства диска, на котором расположена файловая система: %s%n", file.getTotalSpace());

        File[] files = file.listFiles();
            if (files == null) {
                throw new NullPointerException("Ошибка: метод listFiles() вернул null");
            }
        for (File subfile : files) {
            if (subfile.isDirectory()) {
                System.out.printf("Директория: %s%nРазмер директории: %s%n",
                        subfile.getName(), subfile.length());
            }
            if (subfile.isFile()) {
                System.out.printf("Файл: %s%nРазмер файл: %s%n",
                        subfile.getName(), subfile.length());
            }
        }
    }
}
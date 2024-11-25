package ru.job4j.io;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> list = Collections.emptyList();
        try (BufferedReader input = new BufferedReader(new FileReader("data/log.txt"))) {
            list = input.lines()
                    .filter(string -> {
                String[] str = string.split(" ");
                return ("404").equals(str[str.length - 2]);
            })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
                ))) {
             data.forEach(string -> output.printf("%s%n", string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.saveTo("data/404.txt");
        logFilter.filter().forEach(System.out::println);
    }
}
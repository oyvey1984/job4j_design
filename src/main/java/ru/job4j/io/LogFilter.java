package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                boolean rsl = false;
                String[] str = string.split(" ");
                if (("404").equals(str[str.length - 2])) {
                    rsl = true;
                }
                return rsl;
            })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}
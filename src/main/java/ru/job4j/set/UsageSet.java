package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        for (String string : strings) {
            System.out.println("Текущий элемент: " + string);
        }

        strings.remove("two");
        System.out.println("Вывод в консоль после удаления...");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }

        strings.retainAll(List.of("one"));
        System.out.println("Вывод в консоль после удаления...");
        for (String string : strings) {
            System.out.println("Текущий элемент: " + string);
        }
    }
}
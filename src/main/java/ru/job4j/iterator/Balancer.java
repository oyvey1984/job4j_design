package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        Iterator<ArrayList<Integer>> cursor = nodes.iterator();
        while (cursor.hasNext() && source.hasNext()) {
            cursor.next().add(source.next());
            if (!nodes.isEmpty() && !cursor.hasNext() && source.hasNext()) {
                cursor = nodes.iterator();
            }
        }
    }
}
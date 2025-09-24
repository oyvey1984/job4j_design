package ru.job4j.algo.stack;

import java.util.*;

public class Brackets {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<String> stack = new Stack<>();
        String[] strings = s.split("");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(strings));
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        Set<String> set = map.keySet();
        while (!queue.isEmpty()) {
            String currentQueue = queue.poll();
            if (set.contains(currentQueue)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek().equals(map.get(currentQueue))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.add(currentQueue);
            }
        }
        return stack.isEmpty();
    }
}
package ru.job4j.algo.stack;

import java.util.Map;
import java.util.Stack;

public class BracketsVar2 {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

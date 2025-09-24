package ru.job4j.algo.stack;

import java.util.Stack;

class Path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        for (String component : components) {
            if (component.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!component.isEmpty() && !component.equals(".") && !component.equals("..")) {
                stack.push(component);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return !result.isEmpty() ? result.toString() : "/";
    }
}
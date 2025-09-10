package ru.job4j.algo.hash;

import java.util.*;
import java.util.stream.Collectors;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Set<Character> currentSet = new LinkedHashSet<>();
        String longest = "";
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            while (currentSet.contains(currentChar)) {
                currentSet.remove(str.charAt(left));
                left++;
            }

            currentSet.add(currentChar);

            if (currentSet.size() > longest.length()) {
                longest = currentSet.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb"));
        System.out.println(longestUniqueSubstring("abcbcde"));
    }
}
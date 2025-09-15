package ru.job4j.algo.twopoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return null;
        }

        int n = nums.length;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = null;

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            while (frequencyMap.size() >= k) {
                int currentLength = right - left;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    result = new int[]{left, right};
                }
                int leftNum = nums[left];
                frequencyMap.put(leftNum, frequencyMap.get(leftNum) - 1);
                if (frequencyMap.get(leftNum) == 0) {
                    frequencyMap.remove(leftNum);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 5, 5, 5, 7, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
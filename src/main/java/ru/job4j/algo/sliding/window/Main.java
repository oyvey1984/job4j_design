package ru.job4j.algo.sliding.window;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", start, end);
    }
}

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[] {-1, -1};
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Interval> activeIntervals = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));

        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;

        for (Interval current : intervals) {
            while (!activeIntervals.isEmpty() && activeIntervals.peek().end <= current.start) {
                activeIntervals.poll();
            }

            activeIntervals.offer(current);

            if (activeIntervals.size() > maxOverlap) {
                maxOverlap = activeIntervals.size();
                maxStart = current.start;
                maxEnd = activeIntervals.peek().end;
            } else if (activeIntervals.size() == maxOverlap) {
                int currentEnd = activeIntervals.peek().end;
                if (currentEnd - current.start < maxEnd - maxStart) {
                    maxStart = current.start;
                    maxEnd = currentEnd;
                }
            }
        }

        return new int[] {maxStart, maxEnd};
    }

    public static void main(String[] args) {
        List intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}

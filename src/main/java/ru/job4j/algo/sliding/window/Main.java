package ru.job4j.algo.sliding.window;

import java.util.ArrayList;
import java.util.List;

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

class Action {
    boolean isStart;
    int time;

    Action(boolean isStart, int time) {
        this.isStart = isStart;
        this.time = time;
    }
}

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new int[] {-1, -1 };
        }

        List<Action> actions = new ArrayList<>();
        for (Interval it : intervals) {
            actions.add(new Action(true, it.start));
            actions.add(new Action(false, it.end));
        }

        actions.sort((a, b) -> {
            if (a.time != b.time) {
                return Integer.compare(a.time, b.time);
            }
            return Boolean.compare(a.isStart, b.isStart);
        });

        int active = 0;
        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;

        for (Action action : actions) {
            if (action.isStart) {
                active++;
                if (active > maxOverlap) {
                    maxOverlap = active;
                    maxStart = action.time;
                    maxEnd = -1;
                }
            } else {
                if (active == maxOverlap && maxOverlap > 0 && maxEnd == -1) {
                    maxEnd = action.time;
                }
                active--;
            }
        }

        if (maxStart != -1 && maxEnd == -1) {
            int minEnd = Integer.MAX_VALUE;
            for (Interval it : intervals) {
                if (it.start <= maxStart && it.end < minEnd) {
                    minEnd = it.end;
                }
                if (it.start <= maxStart && it.end < minEnd) {
                    minEnd = it.end;
                }
            }
            if (minEnd != Integer.MAX_VALUE) {
                maxEnd = minEnd;
            } else {
                maxEnd = intervals.get(0).end;
            }
        }

        return new int[] {maxStart, maxEnd };
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);
        System.out.println("Interval that overlaps the maximum number of intervals: ["
                + result[0] + ", " + result[1] + "]");
    }
}

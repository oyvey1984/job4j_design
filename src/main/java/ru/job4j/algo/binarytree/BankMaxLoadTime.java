package ru.job4j.algo.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankMaxLoadTime {

    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        if (visitTimes == null || visitTimes.isEmpty()) {
            return new int[]{0, 0};
        }

        List<Event> events = new ArrayList<>();

        for (int[] visit : visitTimes) {
            events.add(new Event(visit[0], EventType.ARRIVAL));
            events.add(new Event(visit[1], EventType.DEPARTURE));
        }

        Collections.sort(events);

        int maxLoad = 0;
        int currentLoad = 0;
        for (Event event : events) {
            if (event.type == EventType.ARRIVAL) {
                currentLoad++;
                if (currentLoad > maxLoad) {
                    maxLoad = currentLoad;
                }
            } else {
                currentLoad--;
            }
        }

        currentLoad = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);

            if (event.type == EventType.ARRIVAL) {
                currentLoad++;
                if (currentLoad == maxLoad) {
                    start = event.time;
                    for (int j = i + 1; j < events.size(); j++) {
                        Event nextEvent = events.get(j);
                        if (nextEvent.time > start) {
                            end = nextEvent.time;
                            break;
                        }
                    }
                    if (end == -1) {
                        end = start + 1;
                    }
                    break;
                }
            } else {
                currentLoad--;
            }
        }

        return new int[]{start, end};
    }

    static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}
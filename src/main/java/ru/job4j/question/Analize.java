package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> prevMap = new HashMap<>();
        Map<Integer, User> currMap = new HashMap<>();

        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }

        for (User user : current) {
            currMap.put(user.getId(), user);
        }

        int added = 0;
        int changed = 0;
        int deleted = 0;

        for (User prevUser : previous) {
            User currUser = currMap.get(prevUser.getId());
            if (currUser == null) {
                deleted++;
            } else if (!prevUser.getName().equals(currUser.getName())) {
                changed++;
            }
        }

        for (User currUser : current) {
            if (!prevMap.containsKey(currUser.getId())) {
                added++;
            }
        }

        return new Info(added, changed, deleted);
    }
}
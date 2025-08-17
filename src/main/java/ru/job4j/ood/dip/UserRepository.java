package ru.job4j.ood.dip;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<Integer, String> users = new HashMap<>();

    public void save(int id, String name) {
        users.put(id, name);
    }

    public String find(int id) {
        return users.get(id);
    }
}

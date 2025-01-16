package ru.job4j.serialization.json;

import java.util.Arrays;

public class Kodiaq {
    private final boolean diesel;
    private final int clearance;
    private final String wheelDrive;
    private final Engine engine;
    private final String[] size;

    public Kodiaq(boolean diesel, int clearance, String wheelDrive, Engine engine, String[] size) {
        this.diesel = diesel;
        this.clearance = clearance;
        this.wheelDrive = wheelDrive;
        this.engine = engine;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Kodiaq{"
                + "diesel=" + diesel
                + ", clearance=" + clearance
                + ", wheelDrive='" + wheelDrive + '\''
                + ", engine=" + engine
                + ", size=" + Arrays.toString(size)
                + '}';
    }
}
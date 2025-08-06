package ru.job4j.ood.lsp.carparking.cars;

import java.util.Objects;

public class Truck implements Vehicle {
    private int size;

    public Truck(int size) {
        if (!(size > 1)) {
            throw new IllegalArgumentException("Размер должен быть больше 1.");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}

package ru.job4j.ood.lsp.carparking.cars;

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
}

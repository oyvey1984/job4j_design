package ru.job4j.ood.lsp.carparking.cars;

public class Car implements Vehicle {
    private static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}

package ru.job4j.ood.lsp.carparking.cars;

import ru.job4j.ood.lsp.carparking.spot.ParkingSpot;

import java.util.Objects;

public class Car implements Vehicle {
    private static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }


}

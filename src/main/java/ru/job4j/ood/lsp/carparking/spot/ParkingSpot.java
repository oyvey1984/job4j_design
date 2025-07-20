package ru.job4j.ood.lsp.carparking.spot;

import ru.job4j.ood.lsp.carparking.cars.Vehicle;

import java.util.Objects;

public class ParkingSpot {
    private Vehicle vehicle;

    public boolean isFree() {
        return vehicle == null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vehicle);
    }
}
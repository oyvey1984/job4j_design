package ru.job4j.ood.lsp.carparking.parking;

import ru.job4j.ood.lsp.carparking.cars.Vehicle;
import ru.job4j.ood.lsp.carparking.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingService {
    List<ParkingSpot> truckSpots;
    List<ParkingSpot> carSpots;

    public ParkingService(int truckSpotsCount, int carSpotsCount) {
        this.truckSpots = new ArrayList<>(truckSpotsCount);
        for (int i = 0; i < truckSpotsCount; i++) {
            truckSpots.add(new ParkingSpot());
        }
        this.carSpots = new ArrayList<>(carSpotsCount);
        for (int i = 0; i < carSpotsCount; i++) {
            carSpots.add(new ParkingSpot());
        }
    }

    boolean add(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }

        if (vehicle.getSize() == 1) {
            for (ParkingSpot spot: carSpots) {
                if (spot.isFree()) {
                    spot.setVehicle(vehicle);
                    return true;
                }
            }
        } else {
            if (vehicle.getSize() > carSpots.size()) {
                return false;
            }
            for (ParkingSpot spot : truckSpots) {
                if (spot.isFree()) {
                    spot.setVehicle(vehicle);
                    return true;
                }
            }

            int neededPlace = vehicle.getSize();
            int free = 0;
            for (ParkingSpot spot : carSpots) {
                if (spot.isFree()) {
                    free++;
                    if (neededPlace == free) {
                        int index = carSpots.indexOf(spot);
                        for (int j = index - neededPlace + 1; j <= index; j++) {
                            carSpots.get(j).setVehicle(vehicle);
                        }
                        return true;
                    }
                } else {
                    free = 0;
                }
            }
        }
        return false;
    }

    public int getFreeCarSpots() {
        int free = 0;
        for (ParkingSpot spot : carSpots) {
            if (spot.isFree()) {
                free++;
            }
        }
        return free;
    }

    public int getFreeTruckSpots() {
        int free = 0;
        for (ParkingSpot spot : truckSpots) {
            if (spot.isFree()) {
                free++;
            }
        }
        return free;
    }

    boolean delete(Vehicle vehicle) {
        if (vehicle.getSize() == 1) {
            for (ParkingSpot spot : carSpots) {
                if (Objects.equals(spot.getVehicle(), vehicle)) {
                    spot.setVehicle(null);
                    return true;
                }
            }
        } else {
            for (ParkingSpot spot : truckSpots) {
                if (Objects.equals(spot.getVehicle(), vehicle)) {
                    spot.setVehicle(null);
                    return true;
                }
            }
            boolean removed = false;
            for (ParkingSpot spot : carSpots) {
                if (Objects.equals(spot.getVehicle(), vehicle)) {
                    spot.setVehicle(null);
                    removed = true;
                }
            }
            return removed;
        }
        return false;
    }

    void removeAll() {
        for (ParkingSpot spot : carSpots) {
            spot.setVehicle(null);
        }

        for (ParkingSpot spot : truckSpots) {
            spot.setVehicle(null);
        }
    }

    public List<ParkingSpot> getCarSpots() {
        return carSpots;
    }

    public List<ParkingSpot> getTruckSpots() {
        return truckSpots;
    }
}

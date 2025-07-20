package ru.job4j.ood.lsp.carparking.parking;

import ru.job4j.ood.lsp.carparking.cars.Vehicle;
import ru.job4j.ood.lsp.carparking.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

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

    List<ParkingSpot> getList() {
        return List.of();
    }

    boolean delete(Vehicle vehicle) {
        return false;
    }

    void removeAll() {

    }

    int hasFreeSpots(Vehicle vehicle) {
        return 0;
    }

    public List<ParkingSpot> getCarSpots() {
        return carSpots; // возвращаем список carSpots
    }

    public List<ParkingSpot> getTruckSpots() {
        return truckSpots;
    }
}

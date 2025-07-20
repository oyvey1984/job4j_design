package ru.job4j.ood.lsp.carparking.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.carparking.cars.Car;
import ru.job4j.ood.lsp.carparking.cars.Truck;
import ru.job4j.ood.lsp.carparking.cars.Vehicle;
import ru.job4j.ood.lsp.carparking.spot.ParkingSpot;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class ParkingServiceTest {

    @Test
    void whenCarAndTruckAddThenTrue() {
        ParkingService parking = new ParkingService(6, 10);
        Vehicle poloSedan = new Car();
        Vehicle scaniaTruck = new Truck(3);
        assertTrue(parking.add(poloSedan));
        assertTrue(parking.add(scaniaTruck));
    }

    @Test
    void whenCarAddThanFalse() {
        ParkingService parking = new ParkingService(6, 3);
        Vehicle poloSedan = new Car();
        Vehicle volvoXC60 = new Car();
        Vehicle mercedesGLE = new Car();
        Vehicle bmw = new Car();
        parking.add(poloSedan);
        parking.add(volvoXC60);
        parking.add(mercedesGLE);
        assertFalse(parking.add(bmw));
    }

    @Test
    void whenTruckAddThanFalse() {
        ParkingService parking = new ParkingService(2, 3);
        Vehicle poloSedan = new Car();
        Vehicle volvoXC60 = new Car();
        Vehicle mercedesGLE = new Car();
        Vehicle scaniaTruck = new Truck(3);
        Vehicle volvoTruck = new Truck(3);
        Vehicle renoTruck = new Truck(3);
        parking.add(poloSedan);
        parking.add(volvoXC60);
        parking.add(mercedesGLE);
        parking.add(scaniaTruck);
        parking.add(volvoTruck);
        assertFalse(parking.add(renoTruck));
    }

    @Test
    void whenTruckAddToCarSpotsThenTrue() {
        ParkingService parking = new ParkingService(2, 10);
        Vehicle poloSedan = new Car();
        Vehicle volvoXC60 = new Car();
        Vehicle mercedesGLE = new Car();
        Vehicle scaniaTruck = new Truck(3);
        Vehicle volvoTruck = new Truck(3);
        Vehicle renoTruck = new Truck(3);
        parking.add(poloSedan);
        parking.add(volvoXC60);
        parking.add(mercedesGLE);
        parking.add(scaniaTruck);
        parking.add(volvoTruck);
        assertTrue(parking.add(renoTruck));
    }

    @Test
    void whenTruckAddToCarSpotsThenFalse() {
        ParkingService parking = new ParkingService(2, 5);
        Vehicle poloSedan = new Car();
        Vehicle volvoXC60 = new Car();
        Vehicle mercedesGLE = new Car();
        Vehicle scaniaTruck = new Truck(3);
        Vehicle volvoTruck = new Truck(3);
        Vehicle renoTruck = new Truck(3);
        parking.add(poloSedan);
        parking.add(volvoXC60);
        parking.add(mercedesGLE);
        parking.add(scaniaTruck);
        parking.add(volvoTruck);
        assertFalse(parking.add(renoTruck));
    }

    @Test
    void whenAddNullVehicleThenFalse() {
        ParkingService parking = new ParkingService(2, 3);
        assertFalse(parking.add(null));
    }

    @Test
    void whenTruckTooBigThenFalse() {
        ParkingService parking = new ParkingService(2, 5);
        Vehicle hugeTruck = new Truck(10);
        assertFalse(parking.add(hugeTruck));
    }

    @Test
    void whenCarSpotsFragmentedThenTruckCantPark() {
        ParkingService parking = new ParkingService(0, 5);

        parking.getCarSpots().get(0).setVehicle(new Car());
        parking.getCarSpots().get(2).setVehicle(new Car());

        Vehicle truck = new Truck(3);
        assertFalse(parking.add(truck));
    }

    @Test
    void whenDeleteVehicleThenSpotsFreed() {
        ParkingService parking = new ParkingService(1, 3);
        Vehicle truck = new Truck(2);
        parking.add(truck);

        assertTrue(parking.delete(truck));
        assertTrue(parking.getTruckSpots().get(0).isFree());
    }

    @Test
    void whenDeleteNonExistentVehicleThenFalse() {
        ParkingService parking = new ParkingService(1, 1);
        assertFalse(parking.delete(new Car()));
    }

    @Test
    void whenRemoveAllThenAllSpotsFree() {
        ParkingService parking = new ParkingService(1, 2);
        parking.add(new Car());
        parking.add(new Truck(2));

        parking.removeAll();

        assertTrue(parking.getTruckSpots().get(0).isFree());
        assertTrue(parking.getCarSpots().stream().allMatch(ParkingSpot::isFree));
    }

}
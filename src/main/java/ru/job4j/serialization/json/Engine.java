package ru.job4j.serialization.json;

public class Engine {
    private final String fuelBrand;
    private final int horsepower;

    public Engine(String fuelBrand, int horsepower) {
        this.fuelBrand = fuelBrand;
        this.horsepower = horsepower;
    }

    public String getFuelBrand() {
        return fuelBrand;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "fuelBrand='" + fuelBrand + '\''
                + ", horsepower=" + horsepower
                + '}';
    }
}

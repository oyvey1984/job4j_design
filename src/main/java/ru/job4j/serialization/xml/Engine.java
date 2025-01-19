package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {

    @XmlAttribute
    private String fuelBrand;
    @XmlAttribute
    private int horsepower;

    public Engine() {
    }

    public Engine(String fuelBrand, int horsepower) {
        this.fuelBrand = fuelBrand;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "fuelBrand='" + fuelBrand + '\''
                + ", horsepower=" + horsepower
                + '}';
    }
}
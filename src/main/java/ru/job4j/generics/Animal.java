package ru.job4j.generics;

import java.util.Objects;

public class Animal {
    private String species;
    private boolean canFly;
    private int numberOfTeeth;

    public Animal(String species, boolean canFly, int numberOfTeeth) {
        this.species = species;
        this.canFly = canFly;
        this.numberOfTeeth = numberOfTeeth;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return canFly == animal.canFly && numberOfTeeth == animal.numberOfTeeth && Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, canFly, numberOfTeeth);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "species='" + species + '\''
                + ", canFly=" + canFly
                + ", numberOfTeeth=" + numberOfTeeth
                + '}';
    }
}
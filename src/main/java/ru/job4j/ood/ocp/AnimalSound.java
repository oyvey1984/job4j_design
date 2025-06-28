package ru.job4j.ood.ocp;

public class AnimalSound {
    public String getSound(String animal) {
        if (animal.equals("lion")) {
            return "roar";
        } else if (animal.equals("mouse")) {
            return "pi";
        } else if (animal.equals("snake")) {
            return "hiss";
        }
        return "";
    }
}
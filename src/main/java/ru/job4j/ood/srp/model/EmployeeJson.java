package ru.job4j.ood.srp.model;

public class EmployeeJson {
    private final String name;
    private final String hired;
    private final String fired;
    private final double salary;

    public EmployeeJson(String name, String hired, String fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }
}
package ru.job4j.solid.srp;

import java.io.FileWriter;
import java.io.IOException;

public class SalesReport {
    public void generateAndSave(Company company) {
        String report = "Доход: " + company.getRevenue();

        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.io;

import java.io.*;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(target)) {
            String line;
            boolean serverDown = false;
            String start = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];
                if (!serverDown && (status.equals("400") || status.equals("500"))) {
                    serverDown = true;
                    start = time;
                }
                if (serverDown && (status.equals("200") || status.equals("300"))) {
                    serverDown = false;
                    writer.println(start + ";" + time + ";");
                }
            }
            if (serverDown) {
                writer.println(start + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
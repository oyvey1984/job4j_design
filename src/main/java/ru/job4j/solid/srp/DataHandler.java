package ru.job4j.solid.srp;

public class DataHandler {
    public Data parse(String raw) {
        return new Data(raw);
    }

    public void sendToServer(Data data) {
        System.out.println("Sending data to server...");
    }
}

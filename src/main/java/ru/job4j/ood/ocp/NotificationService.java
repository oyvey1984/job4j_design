package ru.job4j.ood.ocp;

public class NotificationService {
    private final EmailSender emailSender = new EmailSender();

    public void send(String message) {
        emailSender.sendEmail(message);
    }
}
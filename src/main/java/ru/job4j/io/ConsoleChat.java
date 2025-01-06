package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        List<String> log = new ArrayList();
        List<String> botPhrases = readPhrases(botAnswers);
        Random rand = new Random();

        System.out.printf("Привет! Это консольный чат." + System.lineSeparator()
                + "Ты можешь вводить фразы в консоль."  + System.lineSeparator()
                + "Если ты введёшь:" + System.lineSeparator()
                + "\"%s\" , то программа прекратит отвечать;" + System.lineSeparator()
                + "\"%s\" , то программа снова начнёт отвечать;" + System.lineSeparator()
                + "\"%s\" , то программа прекратит работу." + System.lineSeparator(),
                STOP, CONTINUE, OUT
        );

        String answer = input.nextLine();
        log.add("Пользователь: " + answer);
        boolean canRespond = true;

        while (!OUT.equals(answer)) {
            if (STOP.equals(answer)) {
                canRespond = false;
            } else if (CONTINUE.equals(answer)) {
                canRespond = true;
            } else if (canRespond) {
                String botReply = botPhrases.get(rand.nextInt(botPhrases.size()));
                System.out.println(botReply);
                log.add("Бот: " + botReply);
            }
            answer = input.nextLine();
            log.add("Пользователь: " + answer);
        }
        saveLog(log);
    }

    private List<String> readPhrases(String path) {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                path, StandardCharsets.UTF_8))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("./data/dialog.txt", "./data/botAnswers.txt");
        consoleChat.run();
    }
}
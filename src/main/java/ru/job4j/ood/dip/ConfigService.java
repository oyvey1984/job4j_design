package ru.job4j.ood.dip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigService {
    public String loadConfig() {
        try {
            return Files.readString(Path.of("config.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

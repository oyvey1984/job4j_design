package ru.job4j.cache;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path filePath = Paths.get(cachingDir, key);
        String content = "";

        if (!Files.exists(filePath)) {
            System.err.println("Файл не найден: " + filePath);
            return content;
        }

        if (!Files.isRegularFile(filePath)) {
            System.err.println("Это не обычный файл: " + filePath);
            return content;
        }

        if (!key.endsWith(".txt")) {
            System.err.println("Поддерживаются только текстовые файлы (.txt): " + filePath);
            return content;
        }

        try {
            content = Files.readString(filePath, StandardCharsets.UTF_8);
            System.out.println("Файл успешно загружен: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + filePath);
            e.printStackTrace();
        }

        return content;
    }
}

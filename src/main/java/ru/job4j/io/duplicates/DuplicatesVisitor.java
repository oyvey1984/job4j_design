package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<String>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        File fileForMap = file.toFile();
        if (fileForMap.isFile()) {
            FileProperty property = new FileProperty(fileForMap.length(), fileForMap.getName());
            map.computeIfAbsent(property, path -> new ArrayList<>()).add(fileForMap.getAbsolutePath());
        }
        return super.visitFile(file, attributes);
    }

    public void printEqualsFiles() {
        map.keySet().forEach(element -> {
            List<String> list = map.get(element);
            if (list.size() > 1) {
                System.out.println(element.getName() + " - " + element.getSize() + " bytes");
                list.forEach(System.out::println);
            }
        });
    }
}
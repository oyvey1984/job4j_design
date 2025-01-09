package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    private static ArgsName arguments;

    public static void handle(ArgsName argsName) throws Exception {
        String argsFilter = argsName.get("filter");
        String[] filters = argsFilter.split(",");
        File source = Paths.get(argsName.get("path")).toFile();
        File target = Paths.get(argsName.get("out")).toFile();
        String delimiter = argsName.get("delimiter");
        List<ArrayList<String>> sourceLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(source)
                .useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                ArrayList<String> list = new ArrayList<>();
                Collections.addAll(list, scanner.next().split(delimiter));
                sourceLines.add(list);
            }
        }
        ArrayList<Integer> indexesInSource = new ArrayList<>();
        Arrays.stream(filters).forEach(filter -> indexesInSource.add(sourceLines.get(0).indexOf(filter)));

        try (PrintWriter writer = "stdout".equals(argsName.get("out"))
                ? new PrintWriter(System.out, true)
                : new PrintWriter(new FileWriter(target, StandardCharsets.UTF_8, true))) {
            writeOutput(sourceLines, indexesInSource, delimiter, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOutput(List<ArrayList<String>> sourceLines,
                             List<Integer> indexesInSource,
                             String delimiter,
                             PrintWriter writer) {
        for (ArrayList<String> array : sourceLines) {
            for (int index = 0; index < indexesInSource.size(); index++) {
                writer.print(array.get(indexesInSource.get(index)));
                if (index != indexesInSource.size() - 1) {
                    writer.print(delimiter);
                }
            }
            writer.println();
        }
    }

    public static void validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Not all arguments are specified");
        }
        File fileSource = new File(args[0]);
        if (!fileSource.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", fileSource.getAbsoluteFile()));
        }
        if (!fileSource.isFile()) {
            throw new IllegalArgumentException(String.format("Not file %s", fileSource.getAbsoluteFile()));
        }
        if (!args[0].matches(".*\\.[a-zA-Z]+")) {
            throw new IllegalArgumentException("The fileSource extension is incorrectly specified.");
        }
        File fileTarget = new File(args[2]);
        if (!fileTarget.exists() && !"stdout".equals(args[2])) {
            throw new IllegalArgumentException(String.format("Not exist %s and not stdout", fileTarget.getAbsoluteFile()));
        }
        if (!fileTarget.isFile() && !"stdout".equals(args[2])) {
            throw new IllegalArgumentException(String.format("Not file %s and not stdout", fileTarget.getAbsoluteFile()));
        }
        if (!args[2].matches(".*\\.[a-zA-Z]+") && !"stdout".equals(args[2])) {
            throw new IllegalArgumentException("The fileTarget extension is incorrectly specified.");
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        validate(new String[]{argsName.get("path"), argsName.get("delimiter"),
                argsName.get("out"), argsName.get("filter")});
        handle(argsName);
    }
}
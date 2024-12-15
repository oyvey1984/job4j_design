package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .map(arg -> arg.split("=", 2))
                .forEach(array -> values.put(array[0].substring(1), array[1]));
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        Arrays.stream(args)
                .forEach(arg -> {
                    if (!arg.startsWith("-")) {
                        throw new IllegalArgumentException("Error: This argument '"
                                + arg
                                + "' does not start with a '-' character");
                    }
                    String strForSlit = arg.substring(1);
                    if (!strForSlit.contains("=")) {
                        throw new IllegalArgumentException("Error: This argument '"
                                + arg
                                + "' does not contain an equal sign");
                    }
                    String[] array = strForSlit.split("=", 2);
                    if (array.length < 2 || array[0].isBlank()) {
                        throw new IllegalArgumentException("Error: This argument '"
                                + arg
                                + "' does not contain a key");
                    }
                    if (array[1].isBlank()) {
                        throw new IllegalArgumentException("Error: This argument '"
                                + arg
                                + "' does not contain a value");
                    }
                });
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
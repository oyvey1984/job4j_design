package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.util.StringJoiner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {

    @Test
    void whenTwoTimesServerIsDown(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("300 10:57:01");
            output.println("400 10:58:01");
            output.println("200 11:02:02");
            output.println("500 11:03:04");
            output.println("400 11:04:04");
            output.println("300 11:05:04");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis analyse = new Analysis();
        analyse.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::add);
        }
        assertThat("10:58:01;11:02:02;" + System.lineSeparator() + "11:03:04;11:05:04;")
                .hasToString(result.toString());
    }

    @Test
    void whenOneTimeServerIsDown(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("300 10:57:01");
            output.println("200 11:02:02");
            output.println("500 11:03:04");
            output.println("400 11:04:04");
            output.println("300 11:05:04");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis analyse = new Analysis();
        analyse.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringJoiner result = new StringJoiner(System.lineSeparator());
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::add);
        }
        assertThat("11:03:04;11:05:04;").hasToString(result.toString());
    }
}
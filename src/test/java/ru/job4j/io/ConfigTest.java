package ru.job4j.io;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithCommentAndEmptyLine() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Ayrat Tazetdinov");
    }

    @Test
    void whenPairWithSecondEqual() {
        String path = "./data/pair_with_second_equal.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("junior")).isEqualTo("Ayrat Tazetdinov=1");
        assertThat(config.value("middle")).isEqualTo("Ayrat Tazetdinov=");
    }

    @Test
    void whenPairWithException() {
        String path = "./data/pair_with_exception.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректная строка: ");
    }
}
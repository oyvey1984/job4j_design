package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class GeneratorTest {
    @Test
    public void whenGenerateThenGetTemplate() {
        Generator generator = new StringGeneretor();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ayrat Tazetdinov");
        map.put("subject", "you");
        assertThat(generator.produce(template, map)).isEqualTo("I am a Ayrat Tazetdinov, Who are you?");
    }

    @Test
    public void whenGenerateThenGetException() {
        Generator generator = new StringGeneretor();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ayrat Tazetdinov");
        assertThatThrownBy(() -> generator.produce(template, map)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapSizeMoreThanKeysInTemplate() {
        Generator generator = new StringGeneretor();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ayrat Tazetdinov");
        map.put("subject", "you");
        map.put("star", "doom");
        assertThatThrownBy(() -> generator.produce(template, map)).isInstanceOf(IllegalArgumentException.class);
    }
}
package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, value -> value > 2);
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenReplaceIf() {
        input.add(3);
        input.add(4);
        ListUtils.replaceIf(input, value -> value >= 4, 10);
        assertThat(input).hasSize(4).containsSequence(1, 3, 3, 10);
    }

    @Test
    void whenRemoveAll() {
        input.add(7);
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(1).containsSequence(7);
    }
}
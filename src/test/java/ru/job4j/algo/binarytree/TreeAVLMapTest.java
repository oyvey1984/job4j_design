package ru.job4j.algo.binarytree;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TreeAVLMapTest {

    @Test
    void whenEmptyTree() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.values()).isEmpty();
        assertThat(tree.keySet()).isEmpty();
    }

    @Test
    void whenAddOneElemThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.put(1, "11")).isTrue();
        assertThat(tree.values()).hasSize(1)
                .containsExactly("11");
        assertThat(tree.keySet()).hasSize(1)
                .containsExactly(1);
    }

    @Test
    void whenAddSevenElemThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.put(1, "11")).isTrue();
        assertThat(tree.put(2, "22")).isTrue();
        assertThat(tree.put(3, "33")).isTrue();
        assertThat(tree.put(4, "44")).isTrue();
        assertThat(tree.put(5, "55")).isTrue();
        assertThat(tree.put(6, "66")).isTrue();
        assertThat(tree.put(7, "77")).isTrue();
        assertThat(tree.values()).hasSize(7)
                .containsExactly("11", "22", "33", "44", "55", "66", "77");
        assertThat(tree.keySet()).hasSize(7)
                .containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void whenUpdateValueThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(1, "11");
        tree.put(2, "22");
        tree.put(3, "33");
        tree.put(4, "44");
        tree.put(5, "55");
        tree.put(6, "66");
        tree.put(7, "77");
        assertThat(tree.put(5, "555")).isTrue();
        assertThat(tree.values()).hasSize(7)
                .containsExactly("11", "22", "33", "44", "555", "66", "77");
        assertThat(tree.keySet()).hasSize(7)
                .containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void whenDeleteKeyThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(1, "11");
        tree.put(2, "22");
        tree.put(3, "33");
        tree.put(4, "44");
        tree.put(5, "55");
        tree.put(6, "66");
        tree.put(7, "77");
        assertThat(tree.remove(5)).isTrue();
        assertThat(tree.remove(0)).isFalse();
        assertThat(tree.values()).hasSize(6)
                .containsExactly("11", "22", "33", "44", "66", "77");
        assertThat(tree.keySet()).hasSize(6)
                .containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    void whenGetKeyThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(1, "11");
        tree.put(2, "22");
        tree.put(3, "33");
        tree.put(4, "44");
        tree.put(5, "55");
        tree.put(6, "66");
        tree.put(7, "77");
        assertThat(tree.get(5)).isEqualTo("55");
        assertThat(tree.get(0)).isNull();
    }

    @Test
    void whenAddDescendingKeysThenTreeBalances() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(30, "A");
        tree.put(20, "B");
        tree.put(10, "C");
        assertThat(tree.keySet()).containsExactly(10, 20, 30);
        assertThat(tree.get(20)).isEqualTo("B");
    }

    @Test
    void whenAddAscendingKeysThenTreeBalances() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(10, "A");
        tree.put(20, "B");
        tree.put(30, "C");
        assertThat(tree.keySet()).containsExactly(10, 20, 30);
        assertThat(tree.get(20)).isEqualTo("B");
    }

    @Test
    void whenAddZigZagLeftRightThenBalances() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(30, "A");
        tree.put(10, "B");
        tree.put(20, "C");
        assertThat(tree.keySet()).containsExactly(10, 20, 30);
        assertThat(tree.get(20)).isEqualTo("C");
    }

    @Test
    void whenAddZigZagRightLeftThenBalances() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(10, "A");
        tree.put(30, "B");
        tree.put(20, "C");
        assertThat(tree.keySet()).containsExactly(10, 20, 30);
        assertThat(tree.get(20)).isEqualTo("C");
    }

    @Test
    void whenMinAndMaxRequestedThenReturnCorrectValues() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.put(50, "A");
        tree.put(30, "B");
        tree.put(70, "C");
        tree.put(20, "D");
        tree.put(40, "E");
        tree.put(60, "F");
        tree.put(80, "G");

        assertThat(tree.minimum()).isEqualTo(20);
        assertThat(tree.maximum()).isEqualTo(80);
    }

}
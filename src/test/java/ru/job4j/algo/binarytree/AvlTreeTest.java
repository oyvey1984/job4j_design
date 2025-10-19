package ru.job4j.algo.binarytree;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class AvlTreeTest {

    @Test
    void whenInsertSequentialThenTreeBalancedInOrder() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i <= 7; i++) {
            tree.insert(i);
        }
        assertThat(tree.inSymmetricalOrder()).containsExactly(1, 2, 3, 4, 5, 6, 7);
        assertThat(tree.inPreOrder().get(0)).isEqualTo(4);
    }

    @Test
    void whenInsertDescendingThenTreeBalances() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(10);
        assertThat(tree.inSymmetricalOrder()).containsExactly(10, 30, 50);
        assertThat(tree.inPreOrder()).containsExactly(30, 10, 50);
    }

    @Test
    void whenInsertAscendingThenTreeBalances() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertThat(tree.inSymmetricalOrder()).containsExactly(10, 20, 30);
        assertThat(tree.inPreOrder()).containsExactly(20, 10, 30);
    }

    @Test
    void whenInsertLeftRightCaseThenBalanced() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(30);
        tree.insert(10);
        tree.insert(20);
        assertThat(tree.inSymmetricalOrder()).containsExactly(10, 20, 30);
        assertThat(tree.inPreOrder()).containsExactly(20, 10, 30);
    }

    @Test
    void whenInsertRightLeftCaseThenBalanced() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        assertThat(tree.inSymmetricalOrder()).containsExactly(10, 20, 30);
        assertThat(tree.inPreOrder()).containsExactly(20, 10, 30);
    }

    @Test
    void whenContainsThenReturnsTrueOrFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertThat(tree.contains(20)).isTrue();
        assertThat(tree.contains(100)).isFalse();
    }

    @Test
    void whenRemoveLeafThenRemoved() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        boolean removed = tree.remove(80);
        assertThat(removed).isTrue();
        assertThat(tree.inSymmetricalOrder()).containsExactly(30, 50, 60, 70);
    }

    @Test
    void whenRemoveRootThenTreeStillValid() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        assertThat(tree.inPreOrder()).containsExactly(20, 10, 30);
        boolean removed = tree.remove(20);
        assertThat(removed).isTrue();
        assertThat(tree.inSymmetricalOrder()).containsExactly(10, 30);
    }

    @Test
    void whenFindMinAndMaxThenCorrect() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(50);
        tree.insert(20);
        tree.insert(70);
        tree.insert(10);
        tree.insert(80);
        assertThat(tree.minimum()).isEqualTo(10);
        assertThat(tree.maximum()).isEqualTo(80);
    }

    @Test
    void whenInsertDuplicateThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        assertThat(tree.insert(5)).isTrue();
        assertThat(tree.insert(5)).isFalse();
    }

    @Test
    void whenRemoveNonexistentThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(10);
        tree.insert(20);
        assertThat(tree.remove(30)).isFalse();
    }

    @Test
    void whenInsertNullThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        assertThat(tree.insert(null)).isFalse();
        assertThat(tree.inSymmetricalOrder()).isEmpty();
    }

    @Test
    void whenRemoveFromEmptyTreeThenFalse() {
        AvlTree<Integer> tree = new AvlTree<>();
        assertThat(tree.remove(10)).isFalse();
    }
}

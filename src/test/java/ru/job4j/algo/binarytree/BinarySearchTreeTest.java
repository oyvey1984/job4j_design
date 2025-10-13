package ru.job4j.algo.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void whenAddToEmptyTreeThenListContainsOneElement() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        assertThat(tree.put("first")).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(1)
                .containsExactly("first");
    }

    @Test
    void whenAddTwoToEmptyTreeThenListContainsTwoElement() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        assertThat(tree.put("first")).isTrue();
        assertThat(tree.put("second")).isTrue();
        assertThat(tree.inSymmetricalOrder()).hasSize(2)
                .containsExactly("first", "second");
    }

    @Test
    void whenAddElementThenContainElementOk() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.put("first");
        tree.put("second");
        tree.put("three");
        assertThat(tree.contains("second")).isTrue();
        assertThat(tree.contains("four")).isFalse();
    }

    @Test
    void whenAddMaximumNotEndThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 8, 7}) {
            tree.put(element);
        }
        assertThat(tree.maximum()).isEqualTo(8);
    }

    @Test
    void whenAddMaximumIsEndThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 7}) {
            tree.put(element);
        }
        assertThat(tree.maximum()).isEqualTo(7);
    }

    @Test
    void whenAddMinimumIsEndThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.put(element);
        }
        assertThat(tree.minimum()).isEqualTo(1);
    }

    @Test
    void whenAddMinimumIsNotEndThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7 }) {
            tree.put(element);
        }
        assertThat(tree.minimum()).isEqualTo(2);
    }

    @Test
    void whenSymmetricalOrderThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.put(element);
        }
        assertThat(tree.inSymmetricalOrder()).hasSize(7)
                .containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void whenPreOrderThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.put(element);
        }
        assertThat(tree.inPreOrder()).hasSize(7)
                .containsExactly(4, 2, 1, 3, 6, 5, 7);
    }

    @Test
    void whenPostOrderThenOk() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.put(element);
        }
        assertThat(tree.inPostOrder()).hasSize(7)
                .containsExactly(1, 3, 2, 5, 7, 6, 4);
    }

    @Test
    void whenRemoveLeafNodeThenDeleted() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3); // leaf

        boolean result = tree.remove(3);

        assertThat(result).isTrue();
        assertThat(tree.contains(3)).isFalse();
        assertThat(tree.inSymmetricalOrder()).containsExactly(5, 10, 15);
    }

    @Test
    void whenRemoveNodeWithOneChildThenDeleted() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(1);

        boolean result = tree.remove(3);

        assertThat(result).isTrue();
        assertThat(tree.contains(3)).isFalse();
        assertThat(tree.inSymmetricalOrder()).containsExactly(1, 5, 10, 15);
    }

    @Test
    void whenRemoveNodeWithTwoChildrenThenDeletedCorrectly() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);
        tree.put(6);
        tree.put(8);

        boolean result = tree.remove(5);

        assertThat(result).isTrue();
        assertThat(tree.contains(5)).isFalse();
        assertThat(tree.inSymmetricalOrder()).containsExactly(3, 6, 7, 8, 10, 15);
    }

    @Test
    void whenRemoveNonExistingThenFalse() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(10);
        tree.put(5);

        boolean result = tree.remove(99);

        assertThat(result).isFalse();
        assertThat(tree.inSymmetricalOrder()).containsExactly(5, 10);
    }

    @Test
    public void whenClearThenTreeIsEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(3);
        tree.put(7);

        assertThat(tree.inSymmetricalOrder()).containsExactly(3, 5, 7, 10, 15);
        assertThat(tree.minimum()).isEqualTo(3);
        assertThat(tree.maximum()).isEqualTo(15);
        assertThat(tree.contains(10)).isTrue();
        tree.clear();

        assertThat(tree.inSymmetricalOrder()).isEmpty();
        assertThat(tree.minimum()).isNull();
        assertThat(tree.maximum()).isNull();
        assertThat(tree.contains(10)).isFalse();
    }

    @Test
    public void whenClearEmptyTreeThenNoException() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.clear();
        assertThat(tree.inSymmetricalOrder()).isEmpty();
    }

    @Test
    public void whenClearSingleNodeTreeThenEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(42);
        assertThat(tree.contains(42)).isTrue();
        tree.clear();
        assertThat(tree.contains(42)).isFalse();
        assertThat(tree.inSymmetricalOrder()).isEmpty();
    }

    @Test
    public void whenClearThenCanReuseTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.put(8);
        tree.put(4);
        tree.put(12);

        tree.clear();

        tree.put(100);
        tree.put(50);

        assertThat(tree.inSymmetricalOrder()).containsExactly(50, 100);
        assertThat(tree.contains(100)).isTrue();
    }
}
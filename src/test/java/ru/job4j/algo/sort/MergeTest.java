package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenEmptyArrayThenEmpty() {
        int[] array = {};
        assertThat(Merge.mergesort(array)).isEmpty();
    }

    @Test
    void whenSingleElementThenSame() {
        int[] array = {5};
        assertThat(Merge.mergesort(array)).containsExactly(5);
    }

    @Test
    void whenTwoElementsSortedThenSame() {
        int[] array = {2, 5};
        assertThat(Merge.mergesort(array)).containsExactly(2, 5);
    }

    @Test
    void whenTwoElementsUnsortedThenSorted() {
        int[] array = {5, 2};
        assertThat(Merge.mergesort(array)).containsExactly(2, 5);
    }

    @Test
    void whenAlreadySortedThenSame() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void whenReverseSortedThenSorted() {
        int[] array = {8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void whenAllSameElementsThenSame() {
        int[] array = {5, 5, 5, 5, 5};
        assertThat(Merge.mergesort(array)).containsExactly(5, 5, 5, 5, 5);
    }

    @Test
    void whenNegativeNumbersThenSorted() {
        int[] array = {-5, -2, -10, -1, -8};
        assertThat(Merge.mergesort(array)).containsExactly(-10, -8, -5, -2, -1);
    }

    @Test
    void whenMixedPositiveNegativeThenSorted() {
        int[] array = {-3, 5, -1, 0, 2, -4, 7};
        assertThat(Merge.mergesort(array)).containsExactly(-4, -3, -1, 0, 2, 5, 7);
    }

    @Test
    void whenLargeArrayThenSorted() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        int[] sorted = Merge.mergesort(array);

        for (int i = 0; i < sorted.length - 1; i++) {
            assertThat(sorted[i]).isLessThanOrEqualTo(sorted[i + 1]);
        }

        assertThat(sorted).hasSameSizeAs(array);
        assertThat(sorted).containsExactlyInAnyOrder(array);
    }

    @Test
    void whenOddLengthArrayThenSorted() {
        int[] array = {9, 3, 7, 1, 5};
        assertThat(Merge.mergesort(array)).containsExactly(1, 3, 5, 7, 9);
    }

    @Test
    void whenWithDuplicatesThenSorted() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        assertThat(Merge.mergesort(array)).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 6, 9);
    }
}
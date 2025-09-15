package ru.job4j.algo.twopoint;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoNumberSumTest {
    @Test
    void whenTwoEqualsNumbersYesTarget() {
        int[] array = {5, 5};
        int target = 10;
        int[] result = TwoNumberSum.getIndexes(array, target);
        int[] expected = {0, 1};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTwoEqualsNumbersNoTarget() {
        int[] array = {5, 5};
        int target = 12;
        int[] result = TwoNumberSum.getIndexes(array, target);
        int[] expected = {};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenWithNegativeNumbersYesTarget() {
        int[] array = {-7, -5, 0, 5, 8, 12};
        int target = 3;
        int[] result = TwoNumberSum.getIndexes(array, target);
        int[] expected = {1, 4};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenWithoutNegativeNumbersYesTarget() {
        int[] array = {0, 2, 5, 8, 10, 12};
        int target = 15;
        int[] result = TwoNumberSum.getIndexes(array, target);
        int[] expected = {2, 4};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenArrayHasThreeElementsAndTargetExists() {
        int[] array = {1, 2, 3};
        int target = 5;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {1, 2};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenArrayHasThreeElementsAndTargetNotExists() {
        int[] array = {1, 2, 3};
        int target = 6;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTargetIsSumOfSameNumberButOnlyOneOccurrence() {
        int[] array = {1, 2, 3, 4};
        int target = 2;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTargetIsSumOfFirstTwoElements() {
        int[] array = {1, 2, 4, 6, 8};
        int target = 3;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {0, 1};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTargetIsSumOfLastTwoElements() {
        int[] array = {1, 2, 4, 6, 8};
        int target = 14;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {3, 4};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenArrayHasOnlyTwoElementsAndNoTarget() {
        int[] array = {1, 2};
        int target = 5;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenArrayWithZeroAndTargetExists() {
        int[] array = {-3, -1, 0, 1, 3};
        int target = 0;
        int[] result = TwoNumberSum.getIndexes2Point(array, target);
        int[] expected = {0, 4};
        assertThat(result).isEqualTo(expected);
    }
}
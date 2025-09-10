package ru.job4j.algo.hash;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LongestUniqueSubstringTest {
    @Test
    public void whenStringIsEmpty() {
        String str = "";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("");
    }

    @Test
    public void whenStringHasUniqueCharacters() {
        String str = "abcde";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("abcde");
    }

    @Test
    public void whenStringHasRepeatedCharacters() {
        String str = "abcbcde";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("bcde");
    }

    @Test
    public void whenStringHasAllRepeatedCharacters() {
        String str = "aaaaa";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("a");
    }

    @Test
    public void whenStringHasRepeatingPattern() {
        String str = "abcabcbb";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("abc");
    }

    @Test
    public void whenStringHasLongRepeatingSequence() {
        String str = "pwwkew";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("wke");
    }

    @Test
    public void whenStringHasRepeatedAtBeginning() {
        String str = "aabcde";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("abcde");
    }

    @Test
    public void whenStringHasRepeatedAtEnd() {
        String str = "abcdee";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("abcde");
    }

    @Test
    public void whenStringHasMultipleRepeats() {
        String str = "abacaba";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("bac");
    }

    @Test
    public void whenStringHasSingleCharacter() {
        String str = "x";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("x");
    }

    @Test
    public void whenStringHasTwoSameCharacters() {
        String str = "aa";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("a");
    }

    @Test
    public void whenStringHasTwoDifferentCharacters() {
        String str = "ab";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("ab");
    }

    @Test
    public void whenStringHasRepeatsInMiddle() {
        String str = "abcadef";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("bcadef");
    }

    @Test
    public void whenStringHasComplexPattern() {
        String str = "dvdf";
        assertThat(LongestUniqueSubstring.longestUniqueSubstring(str)).isEqualTo("vdf");
    }
}
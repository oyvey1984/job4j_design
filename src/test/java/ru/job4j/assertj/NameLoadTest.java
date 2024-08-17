package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkMassageNamesArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkMassageDoesNotContainTheSymbol() {
        NameLoad nameLoad = new NameLoad();
        String str = "Key:value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol '='", str)
                .hasMessageContaining("this name: Key:value does not contain the symbol '='")
                .hasMessageContaining("this name: %s does not contain the symbol '='".formatted(str));
    }

    @Test
    void checkMassageDoesNotContainAKey() {
        NameLoad nameLoad = new NameLoad();
        String str = "=value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key", str)
                .hasMessageContaining("this name: =value does not contain a key")
                .hasMessageContaining("this name: %s does not contain a key".formatted(str));
    }

    @Test
    void checkMassageDoesNotContainAValue() {
        NameLoad nameLoad = new NameLoad();
        String str = "Key=";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value", str)
                .hasMessageContaining("this name: Key= does not contain a value")
                .hasMessageContaining("this name: %s does not contain a value".formatted(str));
    }
}
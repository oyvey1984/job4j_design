package ru.job4j.ood.lsp.trade.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.trade.food.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    private Trash trash;
    private Food rottenApple;
    private Food freshApple;

    @BeforeEach
    void setUp() {
        rottenApple = new Food(
                "Rotten Apple",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                50,
                0
        );

        freshApple = new Food(
                "Fresh Apple",
                LocalDate.now().minusDays(2),
                LocalDate.now().plusDays(5),
                50,
                0
        );

        trash = new Trash();
    }

    @Test
    void whenAcceptExpiredProductThenTrue() {
        assertTrue(trash.accept(rottenApple));
    }

    @Test
    void whenAcceptFreshProductThenFalse() {
        assertFalse(trash.accept(freshApple));
    }

    @Test
    void whenAddExpiredProductThenStored() {
        trash.add(rottenApple);
        assertTrue(trash.getList().contains(rottenApple));
    }

    @Test
    void whenRemoveExpiredProductThenListIsEmpty() {
        trash.add(rottenApple);
        assertTrue(trash.delete(rottenApple));
        assertTrue(trash.getList().isEmpty());
    }

    @Test
    void whenRemoveAllThenListIsEmpty() {
        trash.add(rottenApple);
        trash.add(freshApple);
        trash.removeAll();
        assertTrue(trash.getList().isEmpty());
    }
}

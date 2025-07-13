package ru.job4j.ood.lsp.trade.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.trade.food.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;
    private Food milk;
    private Food bread;
    private Food chips;
    private Food sauce;

    @BeforeEach
    void setUp() {
        milk = new Food("Milk",
                LocalDate.now().minusDays(6),
                LocalDate.now().minusDays(1),
                10,
                0);
        bread = new Food("Bread",
                LocalDate.now().minusDays(6),
                LocalDate.now().plusDays(2),
                100,
                10);
        chips = new Food("Chips",
                LocalDate.now().minusMonths(5),
                LocalDate.now().plusMonths(5),
                200,
                0);
        sauce = new Food("Sauce",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusMonths(5),
                300,
                0);
        shop = new Shop();
    }

    @Test
    void whenAcceptValidProductThenTrue() {
        assertTrue(shop.accept(bread));
        assertTrue(shop.accept(chips));
    }

    @Test
    public void whenAcceptExpiredProductThenFalse() {
        assertFalse(shop.accept(milk));
    }

    @Test
    public void checkAddAndDiscountAndPrice() {
        shop.add(bread);
        shop.add(chips);
        assertTrue(shop.getList().contains(bread));
        assertEquals(20, bread.getDiscount());
        assertEquals(80, bread.getPrice());
        assertTrue(shop.getList().contains(chips));
        assertEquals(0, chips.getDiscount());
        assertEquals(200, chips.getPrice());
    }

    @Test
    void whenDeleteProductThenRemoved() {
        shop.add(bread);
        boolean deleted = shop.delete(bread);
        assertTrue(deleted);
        assertFalse(shop.getList().contains(bread));
    }

    @Test
    void whenRemoveAllThenListIsEmpty() {
        shop.add(bread);
        shop.add(chips);
        shop.removeAll();
        assertTrue(shop.getList().isEmpty());
    }
}
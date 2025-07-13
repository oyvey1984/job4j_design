package ru.job4j.ood.lsp.trade.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.trade.food.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse warehouse;
    private Food freshProduct;
    private Food oldProduct;

    @BeforeEach
    void setUp() {
        freshProduct = new Food(
                "Fresh Milk",
                LocalDate.now().minusDays(2),
                LocalDate.now().plusDays(30),
                50,
                0
        );

        oldProduct = new Food(
                "Old Milk",
                LocalDate.now().minusDays(30),
                LocalDate.now().plusDays(10),
                50,
                0
        );

        warehouse = new Warehouse();
    }

    @Test
    void whenAcceptFreshProductThenTrue() {
        assertTrue(warehouse.accept(freshProduct));
    }

    @Test
    void whenAcceptOldProductThenFalse() {
        assertFalse(warehouse.accept(oldProduct));
    }

    @Test
    void whenAddProductThenStored() {
        warehouse.add(freshProduct);
        assertTrue(warehouse.getList().contains(freshProduct));
    }

    @Test
    void whenDeleteProductThenRemoved() {
        warehouse.add(freshProduct);
        boolean deleted = warehouse.delete(freshProduct);
        assertTrue(deleted);
        assertFalse(warehouse.getList().contains(freshProduct));
    }

    @Test
    void whenRemoveAllThenListIsEmpty() {
        warehouse.add(freshProduct);
        warehouse.add(oldProduct);
        warehouse.removeAll();
        assertTrue(warehouse.getList().isEmpty());
    }
}

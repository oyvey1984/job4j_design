package ru.job4j.ood.lsp.trade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.trade.food.Food;
import ru.job4j.ood.lsp.trade.store.Shop;
import ru.job4j.ood.lsp.trade.store.Trash;
import ru.job4j.ood.lsp.trade.store.Warehouse;
import ru.job4j.ood.lsp.trade.store.Store;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {

    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;
    private ControlQuality controlQuality;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        controlQuality = new ControlQuality();
    }

    @Test
    void whenWarehouseAccepts() {
        Food food = new Food(
                "Fresh Apple",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10),
                100,
                0
        );

        List<Store> stores = List.of(warehouse, shop, trash);
        controlQuality.distribute(stores, food);

        assertTrue(warehouse.getList().contains(food));
        assertFalse(shop.getList().contains(food));
        assertFalse(trash.getList().contains(food));
    }

    @Test
    void whenShopAccepts() {
        Food food = new Food(
                "Bread",
                LocalDate.now().minusDays(7),
                LocalDate.now().plusDays(3),
                100,
                0
        );

        List<Store> stores = List.of(warehouse, shop, trash);
        controlQuality.distribute(stores, food);

        assertFalse(warehouse.getList().contains(food));
        assertTrue(shop.getList().contains(food));
        assertFalse(trash.getList().contains(food));
    }

    @Test
    void whenTrashAccepts() {
        Food food = new Food(
                "Expired Milk",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                50,
                0
        );

        List<Store> stores = List.of(warehouse, shop, trash);
        controlQuality.distribute(stores, food);

        assertFalse(warehouse.getList().contains(food));
        assertFalse(shop.getList().contains(food));
        assertTrue(trash.getList().contains(food));
    }

    @Test
    void whenNoStoreAccepts() {
        Food food = new Food(
                "Future Item",
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(10),
                100,
                0
        );

        List<Store> stores = List.of(warehouse, shop, trash);
        controlQuality.distribute(stores, food);

        assertFalse(warehouse.getList().contains(food));
        assertFalse(shop.getList().contains(food));
        assertFalse(trash.getList().contains(food));
    }
}

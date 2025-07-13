package ru.job4j.ood.lsp.trade;

import ru.job4j.ood.lsp.trade.food.Food;
import ru.job4j.ood.lsp.trade.store.Store;

import java.util.List;

public class ControlQuality {
    private List<Store> list;

    public void distribute(List<Store> stores, Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }
}
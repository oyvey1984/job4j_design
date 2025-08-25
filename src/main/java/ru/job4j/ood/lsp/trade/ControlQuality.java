package ru.job4j.ood.lsp.trade;

import ru.job4j.ood.lsp.trade.food.Food;
import ru.job4j.ood.lsp.trade.store.Store;

import java.util.ArrayList;
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

    public void resort(List<Store> stores) {
        List<Food> listFromStore = new ArrayList<>();
        for (Store store : stores) {
            listFromStore.addAll(store.getList());
            store.removeAll();
        }
        for (Food food : listFromStore) {
            food.setDiscount(0);  // Сброс скидки
        }
        for (Food food : listFromStore) {
            distribute(stores, food);
        }
    }
}
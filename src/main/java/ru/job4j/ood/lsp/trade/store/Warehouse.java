package ru.job4j.ood.lsp.trade.store;

import ru.job4j.ood.lsp.trade.food.Food;

public class Warehouse extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        double percent = percentExpirationDateUsedUp(food);
        return percent < 25;
    }
}

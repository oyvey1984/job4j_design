package ru.job4j.ood.lsp.trade.store;

import ru.job4j.ood.lsp.trade.food.Food;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        double percent = percentExpirationDateUsedUp(food);
        return percent >= 25 && percent < 100;
    }

    @Override
    public void add(Food food) {
        double percent = percentExpirationDateUsedUp(food);
        if (percent >= 75 && percent < 100) {
            food.setDiscount(20);
        }
        super.add(food);
    }
}

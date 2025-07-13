package ru.job4j.ood.lsp.trade.store;

import ru.job4j.ood.lsp.trade.food.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        list.add(food);
    }

    @Override
    public List<Food> getList() {
        return list;
    }

    @Override
    public boolean delete(Food food) {
        return list.remove(food);
    }

    @Override
    public void removeAll() {
        list.clear();
    }

    protected double percentExpirationDateUsedUp(Food food) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return usedDays * 100.0 / totalDays;
    }
}

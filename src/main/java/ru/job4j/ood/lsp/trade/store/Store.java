package ru.job4j.ood.lsp.trade.store;

import ru.job4j.ood.lsp.trade.food.Food;

import java.util.List;

public interface Store {

    boolean accept(Food food);

    void add(Food food);

    List<Food> getList();

    boolean delete(Food food);

    void removeAll();
}
package ru.job4j.ood.lsp.trade.food;

import java.time.LocalDate;
import java.util.Objects;

public class Food {
    private String name;
    private LocalDate  createDate;
    private LocalDate  expiryDate;
    private double basePrice;
    private double discount;

    public Food(String name, LocalDate createDate, LocalDate expiryDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.basePrice = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate  getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate  getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate  expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return basePrice * (1 - discount / 100);
    }

    public void setPrice(double price) {
        this.basePrice = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(basePrice, food.basePrice) == 0
                && Double.compare(discount, food.discount) == 0
                && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, basePrice, discount);
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", basePrice=" + basePrice
                + ", discount=" + discount
                + ", finalPrice=" + getPrice()
                + '}';
    }
}

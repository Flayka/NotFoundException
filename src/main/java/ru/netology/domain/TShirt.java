package ru.netology.domain;

public class TShirt extends Product {

    private String color;

    public TShirt() {
    }

    public TShirt(int id, String name, int price, String color) {
        super(id, name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package com.example.entity;

public class Plan {
    private String title;
    private int price;

    public Plan() {

    }

    public Plan(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Plan{" + "title='" + title + '\'' + ", price=" + price + '}';
    }
}

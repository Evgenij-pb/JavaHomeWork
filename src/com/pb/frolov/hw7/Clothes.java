package com.pb.frolov.hw7;

public abstract class Clothes {
    private Size size;
    private int price;
    private String color;

    public Clothes(Size size, int price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

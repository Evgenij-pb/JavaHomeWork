package com.pb.frolov.hw7;

public class Skirt extends Clothes implements WomenClothes{
    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman(){
        System.out.println("Юбка: размер "+ getSize()+", цвет "+getColor()+", цена "+getPrice());
    }
}

package com.pb.frolov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman(){
        System.out.println("Футболка: размер "+ getSize()+", цвет "+getColor()+", цена "+getPrice());
    }

    @Override
    public void dressMan(){
        System.out.println("Футболка: размер "+ getSize()+", цвет "+getColor()+", цена "+getPrice());
    }


}

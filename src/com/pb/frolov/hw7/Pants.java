package com.pb.frolov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Size size, int price, String color) {
        super(size, price, color);
    }



    @Override
    public void dressWoman(){
        System.out.println("Брюки: размер "+ getSize()+", цвет "+getColor()+", цена "+getPrice());
    }

    @Override
    public void dressMan(){
        System.out.println("Брюки: размер "+ getSize()+", цвет "+getColor()+", цена "+getPrice());
    }

}

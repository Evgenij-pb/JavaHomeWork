package com.pb.frolov.hw6;

import java.util.Objects;

public class Cat extends Animal{
    final String kindofAnimal = "кот";
    private  String color;

    public Cat(String food, String location, String nikName,  String color) {
        super(food, location, nikName);
        this.color = color;
    }

    public String getKindofAnimal() {
        return kindofAnimal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println(": МЯУ.");
    }

    @Override
    public void eat() {
        System.out.println("Кот "+getNikName()+" ест: "+ super.getFood()+".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return kindofAnimal.equals(cat.kindofAnimal) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindofAnimal, color);
        //System.out.println("hashCode "+ "кот "+getNikName()+":"+Objects.hash(kindofAnimal, color));
    }

    @Override
    public String toString() {
        return "Кот " + getNikName()+
                ", окрас " + color;
    }

}

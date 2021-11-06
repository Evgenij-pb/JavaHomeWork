package com.pb.frolov.hw6;

import java.util.Objects;

public class Horse extends Animal {
final String kindofAnimal = "конь";
private int  weight;
public int age;

    public Horse(String food, String location, String nikName, int weight, int age) {
        super(food, location, nikName);
        this.weight = weight;
        this.age = age;
    }

    public String getKindofAnimal() {
        return kindofAnimal;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void makeNoise() {
    super.makeNoise();
    System.out.println(": ИГО-ГО");
    }

    @Override
    public void eat() {
        System.out.println("Конь "+getNikName()+" ест: "+ super.getFood()+".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return weight == horse.weight && age == horse.age && kindofAnimal.equals(horse.kindofAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindofAnimal, weight, age);
    }

    @Override
    public String toString() {
        return "Конь " + getNikName() +
                ", вес " + weight +"кг"+
                ", возраст " + age+" лет";
    }
}

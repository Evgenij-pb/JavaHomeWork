package com.pb.frolov.hw6;

import java.util.Objects;

public class Dog extends Animal {
    final String kindofAnimal ="собака" ;
    private String breed; //порода
    private String size;

    public Dog(String food, String location, String nikName, String breed, String size) {
        super(food, location, nikName);
        this.breed = breed;
        this.size = size;
    }

    public String getKindofAnimal() {
        return kindofAnimal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println(": ГАВ-ГАВ.");
    }

    @Override
    public void eat() {
        System.out.println("Cобака "+getNikName()+" ест: "+ super.getFood()+".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return kindofAnimal.equals(dog.kindofAnimal) && breed.equals(dog.breed) && size.equals(dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindofAnimal, breed, size);
        //System.out.println("hashCode "+ "cобака "+getNikName()+":"+Objects.hash(kindofAnimal, breed, size));
    }

    @Override
    public String toString() {
        return "Собака " + getNikName() +
                ", порода " + breed +
                ", размер " + size;
    }
}



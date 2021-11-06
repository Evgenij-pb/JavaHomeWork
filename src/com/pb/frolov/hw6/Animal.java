package com.pb.frolov.hw6;

public class Animal {
    private String food;
    private String location;
    private String kindofAnimal;
    private String nikName;

    //В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.

    public Animal(String food, String location, String nikName) {
        this.food = food;
        this.location = location;
        this.nikName = nikName;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKindofAnimal() {
        return kindofAnimal;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public void makeNoise() {
        System.out.print(getKindofAnimal()+" "+getNikName()+" издает звуки");
    }

    public void eat() {
        System.out.println(getKindofAnimal()+" "+getNikName()+" ест.");
    }

    public void sleep() {
        System.out.println(getKindofAnimal()+" "+getNikName()+" спит.");

    }


}


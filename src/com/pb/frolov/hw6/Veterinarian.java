package com.pb.frolov.hw6;

public class Veterinarian {

    //печатает на экран food и location пришедшего на прием животного
    public void treatAnimal(Animal animal){

        if (animal instanceof Cat){
            System.out.println("Кот ест: "+animal.getFood()+"; живет: "+animal.getLocation() );
        }
        else if (animal instanceof Dog){
            System.out.println("Собока ест: "+animal.getFood()+"; живет: "+animal.getLocation() );
        }
        else if (animal instanceof Horse){
            System.out.println("Лошадь ест: "+animal.getFood()+"; живет: "+animal.getLocation() );
        }
    }
}

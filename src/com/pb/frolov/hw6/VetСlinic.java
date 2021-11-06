package com.pb.frolov.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {

        Animal[] animals = new Animal[4];
        animals[0]=new Cat("молоко, рыба","квартира","Васька","рыжий");
        animals[1]=new Dog("мясо, кости, корм","дача","Шарик","дворняга","средний");
        animals[2]=new Horse("трава, сено, буряк","ферма","Буран",260,5);
        animals[3]=new Dog("мясо, каша","дом","Бобик","такса","маленький");

               System.out.println("----------eat()----------");
        for (Animal a: animals){
            a.eat();
        }

        System.out.println("\n----------makeNoise()----------");
        for (Animal a: animals){
            a.makeNoise();
        }

        System.out.println("\n----------sleep()----------");
        for (Animal a: animals){
            a.sleep();
        }

        System.out.println("\n----------hashCode()----------");
        for (Animal a: animals){
            System.out.println("hashCode "+a.getKindofAnimal()+" "+a.getNikName()+" : "+a.hashCode());
        }

        System.out.println("\n----------toString----------");
        for (Animal a: animals){
            System.out.println(a);
        }

        System.out.println("\n-------equals animals[1] animals[3]----------");
        System.out.println("eq dogs: " +animals[1].equals(animals[3]));

        // Создаем обьект класса Veterinarian с помощью рефлексии
        Class vetClazz = Class.forName("com.pb.frolov.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[]{});
        Object vetDoctor = constr.newInstance();

        System.out.println("\n----------treatAnimal()----------");
        for (Animal a: animals){
            ((Veterinarian)vetDoctor).treatAnimal(a);
        }

    }
}

package com.pb.frolov.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру BINGO \n");
        System.out.println("Вам необходимо отгадать число от 0 до 100");
        System.out.println("для выхода из игры введите чисто больше 100 \n");
        System.out.print("Введите число: ");

        Scanner console = new Scanner(System.in);
        int number = console.nextInt();

        //Generate random int value from 0 to 100
        int randomNumber = (int)(Math.random()*101);

         int counter =1;
         while (number != randomNumber){
                ++counter;
                if (number>100){
                    System.out.println("Конец игры");
                    break;
                }
                if (number>randomNumber){
                    System.out.println("загаданное число меньше");
                }
                else {
                    System.out.println("загаданное число больше");
                }
                System.out.print("\nВведите число: ");
                number = console.nextInt();
         }
         if (number == randomNumber){
                System.out.println("\nПоздравляем, Вы угадали!");
                System.out.println("Количество попыток: "+counter);
         }
    }
}

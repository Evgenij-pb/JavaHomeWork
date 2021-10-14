package com.pb.frolov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = console.nextInt();
        if (number<0 || number>100){
            System.out.print("Ваше число не входит в диапазон [0-100]");
        }
        else if (number <= 14) {
            System.out.print("Ваше число попадает в диапазон [0-14]");
        } else if (number >= 15 && number <= 35) {
            System.out.print("Ваше число попадает в диапазон [15-35]");
        } else if (number >= 36 && number <= 50) {
            System.out.print("Ваше число попадает в диапазон [36-50]");
        } else
            System.out.print("Ваше число попадает в диапазон [51-100]");
    }
}
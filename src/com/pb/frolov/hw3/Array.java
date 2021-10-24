package com.pb.frolov.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println("Поочередно введите целые значения массива ");
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+1 + ": ");
            array[i] = console.nextInt();
        }
        //выводим наш массив
        System.out.println("Наш массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        //Определяем количество положительных элементов
        //Находим сумму всех єлементов
        int counter=0;
        int sumAllelement=0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > 0){
                ++counter;
            }
            sumAllelement = sumAllelement + array[i];
        }
        System.out.print("\n\nКоличество положительных элементов в массиве: "+counter);
        System.out.print("\nСумма всех элементов сассива: " + sumAllelement);

        // сортировка массива
        for (int i = 0; i < (array.length-1); i++){
            for (int j =0; j<(array.length-1-i); j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
        //выводим отсортированный массив
        System.out.println("\n\nНаш массив после сортировки:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}

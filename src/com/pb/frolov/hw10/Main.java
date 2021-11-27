package com.pb.frolov.hw10;

public class Main {

    public static void main(String[] args) {
        NumBox<Integer> NumBoxInt = new NumBox<>(6);

        try {
            NumBoxInt.add(5);
            NumBoxInt.add(11);
            NumBoxInt.add(8);
            NumBoxInt.add(20);
            NumBoxInt.add(1);
            NumBoxInt.add(15);
            NumBoxInt.add(3);
        } catch (Exception e){
            System.err.println("Ошибка! Массив переполнен.\n");
        }

        System.out.println("Количество элементов в NumBoxInt: "+NumBoxInt.length());
        System.out.println("сумма всех элементов: "+NumBoxInt.sum());
        System.out.println("среднее арифметическое элементов: "+NumBoxInt.average());
        System.out.println("значение максимального элемента: "+NumBoxInt.max());
        System.out.println("значение 4го элемента массива: "+NumBoxInt.get(3));

        NumBox<Float> NumBoxFl = new NumBox<>(8);

        NumBoxFl.add(6.8f);
        NumBoxFl.add(5.87f);
        NumBoxFl.add(4.6f);
        NumBoxFl.add(0.5f);
        NumBoxFl.add(2.14f);
        NumBoxFl.add(52.654f);
        NumBoxFl.add(15.33f);


        System.out.println("\nКоличество элементов в NumBoxFl: "+NumBoxFl.length());
        System.out.println("сумма всех элементов: "+NumBoxFl.sum());
        System.out.println("среднее арифметическое элементов: "+NumBoxFl.average());
        System.out.println("значение максимального элемента: "+NumBoxFl.max());
        System.out.println("значение 7го элемента массива: "+NumBoxFl.get(6));




    }




}


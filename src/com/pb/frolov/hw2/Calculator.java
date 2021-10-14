package com.pb.frolov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите 2 целых числа");
        System.out.print("1: ");
        int number1 = console.nextInt();
        System.out.print("2: ");
        int number2 = console.nextInt();
        System.out.print("Введите знак арифметической операции (+,-,*,/): ");
        String sign = console.next();
        switch (sign) {
            case "+":
                System.out.println(number1+sign+number2+ "=" + (number1 + number2));
                break;
            case "-":
                System.out.println(number1+sign+number2+ "=" + (number1 - number2));
                break;
            case "*":
                System.out.println(number1+sign+number2+ "=" + (number1 * number2));
                break;
            case "/":
                if (number2==0) {
                    System.out.println("ошибка: деление на ноль");
                    break;
                }
                System.out.println(number1+sign+number2+ "=" + (number1 / number2));
                break;
            default:
                System.out.println("Недопустимое значение, перезапустите программу...");
        }
    }
}

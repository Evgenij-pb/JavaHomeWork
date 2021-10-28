package com.pb.frolov.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        // Считаю, что строки являются анаграмматическими, если:
        // - количество слов у них равно
        // - количество букв равно
        // - количество одинаковых букв равно
        // - количество слов определенной длинны имею одинаковые буквы
        // (возможно это не все условия)

        Scanner console = new Scanner(System.in);
        System.out.println("Введите строку 1: ");
        String myString = console.nextLine();
        System.out.println("\nВведите строку 2: ");
        String myString1 = console.nextLine();

        //----------Разбиваем строку на массив из слов------------------------
        String[] words = myString.split("[^A-Za-zА-Яа-я]+");
        String[] words1 = myString1.split("[^A-Za-zА-Яа-я]+");
        //-----------------------------------------------------------------------------------------

        //Делаем все буквы маленькие и сортируем элементы массива по алфавиту
        sortByAlphabet(words);
        sortByAlphabet(words1);
        //-------------------------------------------------------------------

        //-----------Находим количество слов в строке 1 и 2--------
        System.out.println("\nколичество слов в строке 1: " + wordsCount(myString));
        System.out.println("количество слов в строке 2: " + wordsCount(myString1));
        //---------------------------------------------------------

        // -----Cоздаем из строки массив символов, оставив только буквы------
        //-------Определяем количество букв в строке----
        //-------Сортируем буквы строк по алфавиту-----
        char[] arr = myString.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase().toCharArray();
        char[] arr1 = myString1.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase().toCharArray();

        System.out.println("\nколичество букв в строке 1: " + arr.length);
        System.out.println("количество букв в строке 2: " + arr1.length);

        Arrays.sort(arr);
        Arrays.sort(arr1);
        //-------------------------------------------------------------------

        //--------определяем являются ли строки анаграмматическими-----------
        if (wordsCount(myString)!=wordsCount(myString)){
            System.out.println("\nВведенные строки не являются анаграмматическими, " +
                    "\nт.к. содержат разное количество слов.");
        }
        else if (arr.length!=arr1.length){
            System.out.println("\nВведенные строки не являются анаграмматическими, " +
                    "\nт.к. содержат разное количество букв.");
        }
        else if(!Arrays.equals(arr,arr1)){
            System.out.println("\nВведенные строки не являются анаграмматическими, " +
                    "\nт.к. имеют разное количество одинаковых букв.");
        }
        else if(Arrays.equals(words,words1)){
            System.out.println("\nВведенные строки являются анаграмматическими, " +
                    "\nт.к. слова одинаковой длинны, содержат одинаковые буквы.");
        }
        else{
            System.out.println("\nВвеленные строки не являются анаграмматическими, " +
                    "\nт.к. слова одинаковой длинны, содержат разные буквы.");
        }
    }

    // wordsCount Определяем количество слов в строке, для этого строку делим на массив из слов,
    // длинна массива будет равна количеству слов
    static int wordsCount(String str) {
        int counter = str.split("[^A-Za-zА-Яа-я]+").length; //   [0-9,\W]+
        return counter;
    }

    //sortByAlphabet Делаем все буквы маленькие и сортируем элементы массива и сам массив по алфавиту
    static String[] sortByAlphabet(String[] words) {
        for (int i = 0; i < (words.length); i++) {
            char[] tmp = words[i].toLowerCase().toCharArray();
            Arrays.sort(tmp);
            words[i] = new String(tmp);
        }
        Arrays.sort(words);
        return words;
    }

    //stringToSortArray Разбиваем строку на массив из слов и сортируем массив в порядке возростания длинны слова
   /* static String[] stringToSortArray (String str){
    String[] words = str.split("[^A-Za-zА-Яа-я]+");
            for (int i = 0; i < (words.length - 1); i++) {
            for (int j = 0; j < (words.length - i - 1); j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String tmp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tmp;
                }
            }
        }
        return words;
    }*/

}
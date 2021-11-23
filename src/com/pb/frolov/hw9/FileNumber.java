package com.pb.frolov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNumber {
    public static void main(String[] args) {

    createNumberFile();
// createNumbersFile - создает текстовый файл "numbers.txt" заполненный
// случайными целыми числами от 1 до 99. 10 строк и по 10 чисел в каждой строке.
// Числа разделены пробелами.

    createOddNumbersFile();
// createOddNumbersFile - читает файл "numbers.txt", и создает на основе
// него новый файл "odd-numbers.txt" в который входят все числа из
// "numbers.txt" только все четные заменены на 0.

    }

    static void createNumberFile(){

        Path path = Paths.get("C:\\1\\numbers.txt");

        try(BufferedWriter writer = Files.newBufferedWriter(path)) {

            StringBuffer myStringBuffer = new StringBuffer();
            for (int j=1; j<=10; j++) {
                int i = 1;
                while (i <= 10) {
                    myStringBuffer.append((int)(Math.random() * 99 + 1)); //(Math.random() * (max - min)) + min максимум не включается, минимум включается
                    myStringBuffer.append(" ");
                    i++;
                }
                System.out.println(myStringBuffer); // выводим сгенерированную строку на экран

                writer.write(myStringBuffer.toString());
                writer.newLine();
                myStringBuffer.setLength(0); //Clearing a string buffer

            }
        }
        catch (Exception ex){
            System.out.println("Error!!!"+ex);
        }
        System.out.println("\nwrite to file " +path.toAbsolutePath()+" done!");
    }

    static void createOddNumbersFile(){
        Path path = Paths.get("C:\\1\\numbers.txt");
        Path path1 = Paths.get("C:\\1\\odd-numbers.txt");

        System.out.println("\nread from file " +path.toAbsolutePath()+" done!");

        try(BufferedReader reader = Files.newBufferedReader(path);
            BufferedWriter writer = Files.newBufferedWriter(path1)) {

            String line;
            StringBuffer myStringBuffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {

                String strArr[] = line.split(" ");

                int [] numArr = new int[strArr.length];          //strArr.length определяем количестко элементов разделенных пробелом

                for (int i = 0; i < strArr.length; i++) {
                    int tmp = Integer.parseInt(strArr[i]);
                    if (tmp % 2 == 0) {                          //если true то четное
                        numArr[i] = 0;
                    } else {
                        numArr[i] = tmp;
                    }
                    myStringBuffer.append(numArr[i]);
                    myStringBuffer.append(" ");

                }

                System.out.println(myStringBuffer);
                writer.write(myStringBuffer.toString());
                writer.newLine();
                myStringBuffer.setLength(0); //Clearing a string buffer

            }
        }

        catch (Exception ex){
            System.out.println("Error!!! "+ex);
        }
        System.out.println("\nwrite to file " +path1.toAbsolutePath()+" done!");
    }

}

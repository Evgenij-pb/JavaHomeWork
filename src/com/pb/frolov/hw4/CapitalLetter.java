package com.pb.frolov.hw4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner console = new Scanner(System.in);
        String myString = console.nextLine();

        //Способ 1

        StringTokenizer tokenizer = new StringTokenizer(myString," ");
        System.out.println("\nСпособ 1");
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken()+" ";
            toUpperCaseFirstLetter(token);
        }

        //Cпособ 2

        String[] myWordMassive = myString.split(" ");
        System.out.println("\n \nСпособ 2");
        for (int i = 0; i < myWordMassive.length; i++) {
            toUpperCaseFirstLetter(myWordMassive[i]+" ");
        }
    }
    //Метод выводит текст, делает заглавной первую букву
    static void toUpperCaseFirstLetter (String str) {
        System.out.print(str.substring(0, 1).toUpperCase() + str.substring(1));
    }
}
// Программа работает
// из недостатков: теряются пробелы если их больше одного подряд
// и в конце преобразованой строки лишний пробел
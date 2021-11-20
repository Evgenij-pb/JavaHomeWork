package com.pb.frolov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Регистрация нового пользователя\n");
        System.out.println("Логин должен иметь 5-20 символов, может содержать  \n" +
                "только латинские буквы и цифры");
        System.out.print("\nЛогин: ");
        String newLogin = console.next();


        System.out.println("Пароль должен иметь 5-20 символов, может содержать  \n" +
                "только латинские буквы, цифры и знак(и) подчеркивания");
        System.out.print("Пароль: ");
        String newPassword = console.next();

        System.out.print("Повторите пароль: ");
        String confirmPassword = console.next();


        Auth auth = new Auth(newLogin,newPassword);
        try {
            auth.signUp(newLogin,newPassword,confirmPassword);
        }
        catch (WrongLoginException e){
            e.printStackTrace();
        }
        catch (WrongPasswordException e){
            e.printStackTrace();
        }

        System.out.println("\nАвторизация\n");

        System.out.print("Логин: ");
        String Login = console.next();
        System.out.print("Пароль: ");
        String Password = console.next();

        try {
            auth.signIn(Login,Password);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        }

    }
}

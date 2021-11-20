package com.pb.frolov.hw8;

public class Auth {

    private String login;
    private String password;


    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException,WrongPasswordException{
        if (!login.matches("[a-zA-Z0-9]{8,}")) {
            throw new WrongLoginException("Логин не " +
                    "соответствует заданным требования");

        }
        else if (!password.matches("[a-zA-Z0-9_]{8,}")) {
            throw new WrongPasswordException("Пароль не" +
                    "соответствует заданным требования");
        }
        else if (!password.equals(confirmPassword)){
            System.out.println("Пароли не совпадают");
            throw new WrongPasswordException("Пароли не совпадают");

        }
        else{
            this.login=login;
            this.password=password;
            System.out.println("Учетная запись создана");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException{
        if (!login.equals(this.login)|!password.equals((this.password))){
           throw new WrongLoginException("Неверный логин или пароль");
        }
        else
            System.out.println("Авторизация успешна!");
    }


}

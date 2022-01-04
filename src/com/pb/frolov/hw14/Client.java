package com.pb.frolov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("Клиент стартовал");
        String serverIp = "127.0.0.1";
        int serverPort = 1234;
        System.out.println("Соединяемся с сервером " + serverIp + ": " + serverPort);

        try {
            Socket server = new Socket(serverIp, serverPort);
            BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            Runnable writeMsg = () -> {
                String dataFromUser, userName;
                try {
                    System.out.print("Введите имя: ");
                    while ((userName = inConsole.readLine()) != null) {
                        outServer.println(userName);
                        break;
                    }
                    System.out.print("Введите сообщение: ");
                    while (true) {

                        if ((dataFromUser = inConsole.readLine()) != null) {
                            outServer.println(dataFromUser);
                        }
                    }
                } catch (IOException e) {
                    //System.err.println(e);
                    System.out.println("ошибка подключения");
                    System.exit(-1);
                }
            };

            Runnable readMsg = () -> {

                String dataFromServer;
                try {
                    while (true) {
                        dataFromServer = inServer.readLine();
                        System.out.println("\n" + dataFromServer);
                        System.out.print("Введите сообщение: ");
                    }

                } catch (IOException e) {
                    //System.err.println(e);
                    System.out.println("ошибка подключения");
                    System.exit(-1);
                }
            };

            Thread readerMsgFromServer = new Thread(readMsg);
            Thread writerMsgToServer = new Thread(writeMsg);

            readerMsgFromServer.start();
            writerMsgToServer.start();

        } catch (IOException e) {
            //System.err.println(e);
            System.out.println("ошибка подключения к серверу");
            System.exit(-1);
        }
    }
}


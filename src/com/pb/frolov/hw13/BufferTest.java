package com.pb.frolov.hw13;

import java.util.ArrayList;
import java.util.List;

public class BufferTest {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    //public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        List<Integer> buffer = new ArrayList<>();

        Runnable produce = () -> {
            synchronized (buffer) {
                try {
                    System.out.println(ANSI_GREEN + "поток Producer стартовал");

                    while (true) {
                        while (buffer.size() == 10) {
                            System.out.println(ANSI_GREEN + "Producer ожидает пока буффер очистится.....");
                            buffer.wait();
                        }
                        while (buffer.size() < 10) {
                            buffer.add((int) ((Math.random() * 800) + 100));
                        }
                        System.out.println(ANSI_GREEN + "Producer заполнил буффер, в буффере " + buffer.size() + " элементов:");
                        for (Integer p : buffer)
                            System.out.print(ANSI_RESET + p + " ");
                        System.out.println(ANSI_GREEN + "\nпоток Producer приостановлен на 3сек");
                        Thread.currentThread().sleep(3000);
                        buffer.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    {
                    }
                }
            }
        };

        Runnable consume = () -> {
            synchronized (buffer) {
                try {
                    System.out.println(ANSI_CYAN + "поток Consumer стартовал");

                    while (true) {
                        while (buffer.size() == 0) {
                            System.out.println(ANSI_CYAN + "Consumer ожидает пока буффер заполнится...");
                            buffer.wait();
                        }
                        System.out.println(ANSI_CYAN + "Consumer считал содержимое буффера:");
                        for (Integer p : buffer) {
                            System.out.print(ANSI_RESET + p + " ");
                        }
                        buffer.clear();
                        System.out.println(ANSI_CYAN + "\nConsumer очистил буффер, в буффере " + buffer.size() + " элементов");

                        buffer.notifyAll();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread producer = new Thread(produce);
        Thread consumer = new Thread(consume);

        consumer.start();
        producer.start();

    }
}

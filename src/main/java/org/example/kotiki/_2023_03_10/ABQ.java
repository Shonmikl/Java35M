package org.example.kotiki._2023_03_10;

import java.util.concurrent.ArrayBlockingQueue;

public class ABQ {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(()-> {
            String[] words = {"Solly", "March", "and", "Levi", "Colwill", "are on", "the list",
                    "for tomorrow", "Tariq", "Lamptey", "I don't know"};

            for (int i = 0; i < words.length && !Thread.interrupted();) {
                try {
                    Thread.sleep(2500);
                    queue.put(words[i]);
                    System.out.println("Producer put into the queue: [" + words[i] + "]"
                    + " element number is: [" + queue.size() + "]");
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()-> {
            StringBuilder sb = new StringBuilder();
            while (!Thread.interrupted()) {
                try {
                    sb.setLength(0);
                    Thread.sleep(5000);
                    sb.append(queue.take());
                    System.out.println("Consumer handled: [" + sb.reverse() + "]"
                            + " element number is: [" + queue.size() + "]");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        consumer.start();

    }
}

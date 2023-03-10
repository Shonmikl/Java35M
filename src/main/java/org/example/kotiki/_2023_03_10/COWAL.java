package org.example.kotiki._2023_03_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWAL {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Misha");
        list.add("Evgeny");
        list.add("Vlad");
        list.add("Marina");
        list.add("Artem");


        Thread T1 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        });

        Thread T2 = new Thread(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(2);
            list.add("Lera");
        });

        T1.setName("[ITERATOR THREAD]");
        T2.setName("[CHANGER THREAD]");

        T1.start();
        T2.start();

        T1.join();
        T1.join();

        System.out.println(list);
    }
}
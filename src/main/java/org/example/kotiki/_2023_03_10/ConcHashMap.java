package org.example.kotiki._2023_03_10;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcHashMap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Misha");
        map.put(2, "Evgeny");
        map.put(3, "Vlad");
        map.put(4, "Marina");
        map.put(5, "Artem");
//        map.put(null, "TEST");

        Thread T1 = new Thread(() -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        });

        Thread T2 = new Thread(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Lera");
        });

        T1.start();
        T2.start();

        T1.join();
        T1.join();

        System.out.println(map);
    }
}
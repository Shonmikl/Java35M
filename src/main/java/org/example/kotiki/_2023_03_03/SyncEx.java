package org.example.kotiki._2023_03_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SyncEx {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        List<Integer> target = Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> target.addAll(list);

        Thread T1 = new Thread(runnable);
        Thread T2 = new Thread(runnable);

        T1.start();
        T2.start();

        T1.join();
        T2.join();

        System.out.println(target);

    }
}

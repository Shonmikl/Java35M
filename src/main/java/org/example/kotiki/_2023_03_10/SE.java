package org.example.kotiki._2023_03_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SE {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //ArrayList<Integer> target = new ArrayList<>();
        List<Integer> synchList =
                Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> synchList.addAll(list);

        Thread T1 = new Thread(runnable);
        Thread T2 = new Thread(runnable);

        T1.start();
        T2.start();

        T1.join();
        T2.join();

        System.out.println(synchList);
    }
}

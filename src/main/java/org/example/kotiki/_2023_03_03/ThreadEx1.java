package org.example.kotiki._2023_03_03;

import java.util.concurrent.Callable;

public class ThreadEx1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunImpl());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
        System.out.println("Main end");
    }
}

class CallImpl implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class RunImpl implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
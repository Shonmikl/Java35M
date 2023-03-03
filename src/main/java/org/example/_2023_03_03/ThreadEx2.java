package org.example._2023_03_03;

public class ThreadEx2 {
    static int counter = 0;

    public static void increment() {
        synchronized (ThreadEx2.class) {
            counter++;
            System.out.println("[" + counter + "]");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RUN());
        Thread t2 = new Thread(new RUN());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter: " + counter);
    }
}

class RUN implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1500);
                ThreadEx2.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

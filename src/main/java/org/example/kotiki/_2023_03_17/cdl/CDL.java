package org.example.kotiki._2023_03_17.cdl;

import java.util.concurrent.CountDownLatch;

public class CDL {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void getConnectionFromDB() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Connected to DATABASE");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    private static void getParameters() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Got parameters");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    private static void calculateParameters() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Parameters were calculated");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    public static void main(String[] args)  {
        new AppService("Permission card is on", countDownLatch);
        new AppService("Security setUp", countDownLatch);
        new AppService("ERP system is ready to work", countDownLatch);

        try {
            getConnectionFromDB();
            getParameters();
            calculateParameters();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AppService extends Thread {
    String appName;
    private CountDownLatch countDownLatch;

    public AppService(String appName, CountDownLatch countDownLatch) {
        this.appName = appName;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("[ " + appName + " : start ]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package org.example.kotiki._2023_03_17.phaser;

import java.util.concurrent.Phaser;

public class PH {
    //todo добавить инфы
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            this.start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("[" + getName() + ": is shampoo the car");
                    sleep(2500);
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
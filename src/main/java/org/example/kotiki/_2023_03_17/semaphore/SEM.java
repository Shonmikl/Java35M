package org.example.kotiki._2023_03_17.semaphore;

import java.util.concurrent.Semaphore;

/**
 * try { m1 --> Exception e
 * m2 --> IOBE e
 * } catch (IOBE e) --> I1
 * } catch (Exception e) --> I2
 */

public class SEM {
    public static void main(String[] args) {

        Semaphore room = new Semaphore(2);
        new Employee("Vlad", room);
        new Employee("Mikhail", room);
        new Employee("Evgeny", room);
        new Employee("Lera", room);
        new Employee("Myroslava", room);
        new Employee("Artem", room);
        new Employee("Vlad_2", room);
    }
}

class Employee extends Thread {
    private String name;
    private Semaphore room;

    public Employee(String name, Semaphore room) {
        this.name = name;
        this.room = room;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("[" + name + " is waiting for....]");
            room.acquire();
            sleep(1500);
            System.out.println("[" + name + " is using a room]");
            sleep(2000);
            System.out.println("[" + name + " went away]");
            sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            room.release();
        }
    }
}
package org.example.kotiki._2023_03_10;

public class MethodRef {
    public static void main(String[] args) {
        m1(() -> {
            System.out.println("!!!!");
            System.out.println("####");
            System.out.println("****");
        });
    }

    public static void m1(Inter inter) {
        System.out.println("@@@@");
        inter.get();
    }
}

@FunctionalInterface
interface Inter {
    void get();
}
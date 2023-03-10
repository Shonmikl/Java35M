package org.example.kotiki._2023_03_10;

public class MethodRef1 {
    public static void main(String[] args) {
        m1(MethodRef1::m2);
    }

    public static void m2() {
        System.out.println("!!!!");
        System.out.println("####");
        System.out.println("****");
    }

    public static void m1(Inter1 inter1) {
        System.out.println("@@@@");
        inter1.get();
    }
}

@FunctionalInterface
interface Inter1 {
    void get();
}
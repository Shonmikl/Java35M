package org.example.kotiki;

import com.github.javafaker.Faker;

public class Test {
    public static void main(String[] args) {
        Faker f = new Faker();
        System.out.println(f.name().toString());
    }
}
package org.example.kotiki._2023_03_24.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Test1 {
    public static void main(String[] args) {

    }

}

class A {

    @Deprecated
    void get() {
        System.out.println("!!!!");
    };
}
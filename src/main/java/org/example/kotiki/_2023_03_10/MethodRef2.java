package org.example.kotiki._2023_03_10;

import java.util.Arrays;
import java.util.List;

public class MethodRef2 {
    public static void main(String[] args) {
        List<String> s = Arrays.asList("Evgeny", "Vlad", "Lera", "Myroslava");
        s.forEach(System.out::println);
    }
}

package org.example.kotiki._2023_02_24;

import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    static int[] a = {1};

    static void get(int[] ae) {
        ae[0] = 11;
        System.out.println(Arrays.toString(ae));
        System.out.println(Arrays.toString(a));
    }

    public static <T> void setIfNotNull(@Nullable T value, Consumer<T> setter) {
        if (value != null) {
            setter.accept(value);
        }
    }

    public static void main(String[] args) {

        Map<String, String> monthToSeason = Arrays.stream(java.time.Month.values())
                .collect(Collectors.toMap(Enum::name, m -> switch (m.ordinal()) {
            case 1, 2, 12 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "";
        }));
        System.out.println(monthToSeason.get("June"));
    }

}
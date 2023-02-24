package org.example._2023_02_24;

import lombok.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;

    private List<Integer> list;

    public int getSum(int a, int b) {
        //**********
        return a + b;
    }

    public int[] removeCommonElem(int[] arr) {
        Objects.requireNonNull(arr);
        return Arrays.stream(arr).distinct().toArray();
    }

    public void save(int el) {
        list.add(el);
    }
}
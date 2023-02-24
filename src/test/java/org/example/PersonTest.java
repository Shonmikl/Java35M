package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class PersonTest {

    private final Person person = new Person();
    private List<Integer> list = new LinkedList<>();

    @Test
    void getSumTest() {
        int expected = 4;
        Assertions.assertEquals(expected, person.getSum(2,2));
    }

    @Test
    void removeCommonElemTest() {
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3, 3};

        Assertions.assertArrayEquals(expectedArray, person.removeCommonElem(actualArray));
    }

    @Test
    public void save(int el) {

    }
}
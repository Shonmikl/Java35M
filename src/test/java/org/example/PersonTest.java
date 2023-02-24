package org.example;

import org.example._2023_02_24.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class PersonTest {

    private final Person person = new Person();
    private List<Integer> list = new LinkedList<>();

    @AfterEach
    void setUp() {
        person.getList().clear();
    }

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
    public void saveTest() {
        int expectedSize = 1;

        person.save(1);
        Assertions.assertEquals(expectedSize, person.getList().size());
    }
}
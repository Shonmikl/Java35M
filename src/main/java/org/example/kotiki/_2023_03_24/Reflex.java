package org.example.kotiki._2023_03_24;

import java.lang.reflect.Field;
import java.util.List;

public class Reflex {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class employeeClass = Class.forName("org.example.kotiki._2023_03_24.emp.Employee");
        Field field = employeeClass.getField("id");

        System.out.println("Field: " + field);
        Field[] fields = employeeClass.getDeclaredFields();
        System.out.println("******************************************");

        for (Field f : fields) {
            System.out.println("Field: " + f);
        }
        System.out.println("******************************************");

        Field[] fields1 = employeeClass.getDeclaredFields();
        for (Field f : fields1) {
            System.out.println("Field: " + f);
        }
    }
}
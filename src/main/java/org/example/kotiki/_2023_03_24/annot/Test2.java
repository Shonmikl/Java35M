package org.example.kotiki._2023_03_24.annot;

import java.lang.annotation.*;

/**
 * На дом!
 * Сделать свою аннотацию "Setter"
 */

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class samsung = Class.forName("org.example.kotiki._2023_03_24.annot.Samsung");
        Annotation annotation1 = samsung.getAnnotation(Phone.class);
        Phone phone1 = (Phone) annotation1;
        System.out.println("Annotation samsung info: " + phone1.OS() + " : " + phone1.issue());

        Class iphone = Class.forName("org.example.kotiki._2023_03_24.annot.IPhone");
        Annotation annotation2 = iphone.getAnnotation(Phone.class);
        Phone phone2 = (Phone) annotation2;
        System.out.println("Annotation iphone info: " + phone2.OS() + " : " + phone2.issue());
    }
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Phone {
    String OS() default "ANDROID";

    int issue() default 2021;


}

@Phone(issue = 2022)
class Samsung {
    String model;
    double price;
}

@Phone(OS = "IOS")
class IPhone {
    String model;
    double price;
}
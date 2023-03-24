package org.example.kotiki._2023_03_24.emp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.kotiki._2023_03_24.annot.MA;

@ToString(exclude = {"id", "name"}, callSuper = true)
public class Employee {
    public int id;
    public String name;

    @Getter
    @Setter
    private double salary;
    public String department;

    public Employee() {
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @MA
    private void changeDep(String newDep) {
        department = newDep;
        System.out.println("New department is: " + department);
    }

    public static void main(String[] args) {
        System.out.println(new Employee(1, "Name", 654321, "IT"));
    }
}
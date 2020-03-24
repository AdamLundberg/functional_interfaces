package se.lexicon.adam;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.println("Line 3");
        }).start();

        Employee john = new Employee("John doe", 30);
        Employee tim = new Employee("Tim", 33);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

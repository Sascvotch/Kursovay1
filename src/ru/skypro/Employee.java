package ru.skypro;

import java.util.Objects;

public class Employee {
    private static int id;
    private String name;
    private String lastName;
    private String  middleName;
    private int numberDepartment;
    private double salary;

    public Employee( String name, String lastName, String middleName, int numberDepartment, double salary) {
        id = id++;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.numberDepartment = numberDepartment;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getNumberDepartment() {
        return numberDepartment;
    }

    public void setNumberDepartment(int numberDepartment) {
        this.numberDepartment = numberDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", numberDepartment='" + numberDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String toStringFullName() {
        String fullNAme = lastName + " " + name + " " + middleName;
        return fullNAme ;

    }
}

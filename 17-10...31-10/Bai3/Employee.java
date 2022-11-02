package Bai3;

import java.util.Date;

public class Employee extends Person {
    Date dateJoin;
    String position;
    double salaryLevel;
    static double basicSalary; 

    public Employee(String name, int yearOfBirth, Gender gender) {
        super(name, yearOfBirth, gender);
    }

    public int getId() {
        return this.id;
    }

    public double getIncome() {
        return basicSalary*salaryLevel;
    }

    public void setBasicSalary(double newSalary) {
        basicSalary = newSalary;
    }

    public void setSalaryLevel(double salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public void display() {
        System.out.print(id + " ");
        System.out.print(name + " ");
        System.out.print(yearOfBirth + " ");
        System.out.print(gender + " ");
        System.out.print(dateJoin + " ");
        System.out.print(position + " ");
        System.out.print(getIncome());
        System.out.println();
    }
}

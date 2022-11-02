package Bai3;

import Bai3.Person.Gender;

public class TestCompany {
    public static void main(String[] args) {
        Person p1 = new Person("Manh", 2002, Gender.Male);
        System.out.println(p1.id);
        Person p2 = new Person("Nam", 2002, Gender.Male);
        System.out.println(p2.id);
        Employee e1 = new Employee("Nghia", 2002, Gender.Male);

        Company company1 = new Company("BKAV", null);
        company1.showListEmployee();
        company1.addNewEmployee(e1);
        company1.showListEmployee();
    } 
}

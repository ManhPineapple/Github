package Bai3;

import java.sql.Date;

public class Company {
    String name;
    Date dateCreate;
    Employee employees[] = new Employee[10];
    int numOfEmployee; 

    public Company(String name, Date dateCreate) {
        this.name = name;
        this.dateCreate = dateCreate;
        numOfEmployee = 0;
    }

    public String getName() {
        return this.name;
    }

    public void showListEmployee() {
        if (numOfEmployee > 0) {
            System.out.println("List of Employee:");
            for (int i=0; i<numOfEmployee; i++) {
                System.out.print(employees[i].getName() + " ");
            }
        } else System.out.println("This company doesn't have an Employee!");
    }

    public void addNewEmployee(Employee e) {
        if (numOfEmployee < 10) {
            employees[numOfEmployee] = e;
            numOfEmployee ++;
        } else System.out.println("Number of Employee reach limit!");
    }

    public void info() {
        if (numOfEmployee == 10) System.out.println("Number of Employee reach limit!");
        else System.out.println("Can apply more Employee");
    }
}

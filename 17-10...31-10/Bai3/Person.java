package Bai3;

public class Person {
    static int cur_id = 0;
    enum Gender {Male, Female};

    int id;
    String name;
    final int yearOfBirth;
    Gender gender;

    public Person(String name, int yearOfBirth, Gender gender) {
        cur_id++;
        id = cur_id;
        this.name = name; 
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
    
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void display() {
        System.out.print(id + " ");
        System.out.print(name + " ");
        System.out.print(yearOfBirth + " ");
        System.out.print(gender);
        System.out.println();
    }
}

package pl.strefakursow.hibernatedemo1.entity;

public class Employee {
    private String FirstName;
    private String LastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.age = age;
    }

    public Employee() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

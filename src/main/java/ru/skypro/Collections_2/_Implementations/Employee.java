package ru.skypro.Collections_2._Implementations;

import java.util.Objects;

public class Employee {
    //private final String firstName;
    //private final String lastName;
    private String fullName;
    private String phoneNumber;

    public Employee(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        //this.firstName = firstName;
        //this.lastName = lastName;
    }

    /*public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

     */
    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(fullName, employee.fullName) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
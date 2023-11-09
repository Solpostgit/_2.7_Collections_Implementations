package ru.skypro.Collections_2._Implementations.services;

import ru.skypro.Collections_2._Implementations.Employee;

import java.util.List;

public interface EmployeeService {
    Employee put(String fullName, String phoneNumber);
    Employee get(String fullName, String phoneNumber);
    Employee remove(String fullName, String phoneNumber);
    //List<Employee> getAll();
}

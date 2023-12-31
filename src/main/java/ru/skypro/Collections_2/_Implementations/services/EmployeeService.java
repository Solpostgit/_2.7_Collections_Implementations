package ru.skypro.Collections_2._Implementations.services;

import ru.skypro.Collections_2._Implementations.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Map<String, Employee> getAll();
}

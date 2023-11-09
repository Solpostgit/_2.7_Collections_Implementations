package ru.skypro.Collections_2._Implementations.services.impl;

import org.springframework.stereotype.Service;
import ru.skypro.Collections_2._Implementations.Employee;
import ru.skypro.Collections_2._Implementations.exception.EmployeeAlreadyAddedException;
import ru.skypro.Collections_2._Implementations.exception.EmployeeNotFoundException;
import ru.skypro.Collections_2._Implementations.exception.EmployeeStorageIsFullException;
import ru.skypro.Collections_2._Implementations.services.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int STORAGE_SIZE = 5;

    //private final List<Employee> employees = new ArrayList<>();
    private final Map<String, String> employeeMap = new HashMap<>();
    @Override
    public Employee put(String firstName, String lastName) {
        if (employeeMap.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Не можем добавить сотрудника! Хранилище уже полное.");
        }

        Employee employee = new Employee(String fullName);
        if (employeeMap.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с именем " + employee.getFullName() + "и номером " + employee.getPhoneNumber() + " уже имеется в хранилище!");
        }
        employeeMap.put(employee.getFullName(), employee.getPhoneNumber());
        return employee;
    }

    @Override
    public Employee remove(String fullName) {
        Employee employee = new Employee(fullName);
        if (!employeeMap.containsKey(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с именем " + firstName + " и фамилией " + lastName + " не найден в хранилище!");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee requestedEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(requestedEmployee)) {
                return requestedEmployee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с именем "+firstName+" и фамилией "+lastName+" не найден в хранилище!");
    }
    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}

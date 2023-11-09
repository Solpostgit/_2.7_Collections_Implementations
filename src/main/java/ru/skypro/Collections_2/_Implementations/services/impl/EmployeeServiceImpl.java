package ru.skypro.Collections_2._Implementations.services.impl;

import org.springframework.stereotype.Service;
import ru.skypro.Collections_2._Implementations.Employee;
import ru.skypro.Collections_2._Implementations.exception.EmployeeAlreadyAddedException;
import ru.skypro.Collections_2._Implementations.exception.EmployeeNotFoundException;
import ru.skypro.Collections_2._Implementations.exception.EmployeeStorageIsFullException;
import ru.skypro.Collections_2._Implementations.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int STORAGE_SIZE = 5;
    private final List<Employee> employees = new ArrayList<>();
    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Не можем добавить сотрудника !Хранилище уже полное.");
        }

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с именем " + firstName + "и фамилией " + lastName + " уже имеется в хранилище!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
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

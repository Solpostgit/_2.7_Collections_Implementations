package ru.skypro.Collections_2._Implementations.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}

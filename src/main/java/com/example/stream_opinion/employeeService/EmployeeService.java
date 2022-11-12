package com.example.stream_opinion.employeeService;

import com.example.stream_opinion.employee.Employee;
import com.example.stream_opinion.exception.EmployeeAlreadyAddedException;
import com.example.stream_opinion.exception.EmployeeNotFoundException;
import com.example.stream_opinion.exception.EmployeeStorageIsFullException;
import com.example.stream_opinion.employee.Employee;
import com.example.stream_opinion.exception.EmployeeAlreadyAddedException;
import com.example.stream_opinion.exception.EmployeeNotFoundException;
import com.example.stream_opinion.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }



    public Employee addEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    public Employee findEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    public Employee removeEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}

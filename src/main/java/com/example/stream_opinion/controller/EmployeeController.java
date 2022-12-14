package com.example.stream_opinion.controller;

import com.example.stream_opinion.employee.Employee;
import com.example.stream_opinion.employeeService.EmployeeService;
import com.example.stream_opinion.employee.Employee;
import com.example.stream_opinion.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstname") String name,
                        @RequestParam("lastname") String surname,
                        @RequestParam("departmentId") int department,
                        @RequestParam double salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstname") String name,
                         @RequestParam("lastname") String surname,
                         @RequestParam("departmentId") int department,
                         @RequestParam double salary) {
        return employeeService.findEmployee(name, surname, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstname") String name,
                           @RequestParam("lastname") String surname,
                           @RequestParam("departmentId") int department,
                           @RequestParam double salary) {
        return employeeService.removeEmployee(name, surname, department, salary);
    }
}

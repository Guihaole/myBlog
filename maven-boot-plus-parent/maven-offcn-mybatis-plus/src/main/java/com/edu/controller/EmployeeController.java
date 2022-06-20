package com.edu.controller;

import com.edu.bean.Employee;
import com.edu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("list")
    //http://localhost:8080/employee/list
    public List<Employee> employeeList(){
        return employeeService.employeeList();
    }
}

package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.bean.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    public List<Employee> employeeList();
}

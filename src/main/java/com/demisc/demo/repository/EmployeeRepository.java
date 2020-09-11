package com.demisc.demo.repository;

import com.demisc.demo.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
}

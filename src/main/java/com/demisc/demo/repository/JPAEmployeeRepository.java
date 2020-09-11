package com.demisc.demo.repository;

import com.demisc.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class JPAEmployeeRepository implements EmployeeRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(Integer id) {
        return manager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}

package com.demisc.demo;

import com.demisc.demo.model.Employee;
import com.demisc.demo.repository.EmployeeRepository;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringDataJpaApplicationTests {
    @Autowired
    JPA2EmployeeRepo repo;

    @Test
    void contextLoads() {
    }
    @Test
    void jpatestone(){
//        Optional<Employee> employee = repo.findById(2);
//        if (employee.isPresent())
//            System.out.println(employee.get());
//        List<Employee> employees = repo.getEmployeeLike("h");
//        System.out.println(employees);
//        repo.updatename("sosi",9);
//        repo.deleteByName("mahsa");


        PageRequest request = PageRequest.of(0,2, Sort.by("name"));
        repo.findAll(request);
    }


}

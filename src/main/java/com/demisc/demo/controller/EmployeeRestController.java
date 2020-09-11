package com.demisc.demo.controller;

import com.demisc.demo.exception.EmployeeNotFound;
import com.demisc.demo.model.Employee;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {
    private JPA2EmployeeRepo repo;
    public EmployeeRestController(JPA2EmployeeRepo repo) {
        this.repo = repo;
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFound {
        return repo.findById(id).orElseThrow(EmployeeNotFound::new);
    }

    @GetMapping
    public List<Employee> getAllEmployee(@RequestParam int pageNum){
        PageRequest page = PageRequest.of(pageNum,2);
        return repo.findAll(page).getContent();
    }
    @PostMapping("/save")
    public Employee saveEmp(@RequestBody Employee employee){
        repo.save(employee);
        return employee;
    }
    @RequestMapping("/emp/{id}")
    @ResponseBody
    public Optional<Employee> getEmp(@PathVariable int id){
       return repo.findById(id);

    }
    @RequestMapping("/emp")
    @ResponseBody
    public List<Employee> getEmployees(){
        return (List<Employee>) repo.findAll();

    }
    @RequestMapping("/emp1/{id}")
    @ResponseBody
    public String getEmpby(@PathVariable int id){
        return repo.findById(id).toString();

    }

}

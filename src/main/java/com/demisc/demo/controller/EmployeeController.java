package com.demisc.demo.controller;

import com.demisc.demo.exception.EmployeeNotFound;
import com.demisc.demo.model.Employee;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class EmployeeController {

    private JPA2EmployeeRepo repo;

    @Autowired
    public EmployeeController(JPA2EmployeeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("{id}")
    public String showById(Model model, @PathVariable int id) throws EmployeeNotFound {
        if (!model.containsAttribute("employee")){
//        Employee employee = repo.findById(id).get();
            Employee employee = repo.findById(id).orElseThrow(EmployeeNotFound::new);
            model.addAttribute("employee", employee);
        }

        return "emp/showEmployee";
    }

    @GetMapping("/show")
    public String findById(Model model, @RequestParam(value = "id", defaultValue = "1") int id) throws EmployeeNotFound {
//        Employee employee = repo.findById(id).get();
        Employee employee = repo.findById(id).orElseThrow(EmployeeNotFound::new);
        model.addAttribute("employee", employee);
        return "emp/showEmployee";
    }

    @PostMapping("save")
    public Employee createEmployee(@Validated @RequestBody Employee emp) {
        return repo.save(emp);


    }

    @GetMapping("/get")
    public List<Employee> getAlEmployees() {
        return (List<Employee>) repo.findAll();
    }
    @GetMapping("/register")
    public String showFormReg(Model model){
        model.addAttribute("employee",new Employee());
        return "emp/register";
    }
//    @PostMapping("/register")
//    public String regEmp(@Valid Employee employee, Errors errors, RedirectAttributes model){
//        repo.save(employee);
//        model.addAttribute("id",employee.getId());
//        model.addFlashAttribute("employee", employee);
//        return "redirect:/employee/{id}";
//    }

    @GetMapping("/employee/findById")
    public String findById(@RequestParam int id,Model model){
        Employee employee = repo.findById(id).get();
        model.addAttribute("employee", employee);
        return "emp/update";
    }


    @GetMapping("/employee")
    public String showAll(Model model) {
        model.addAttribute("employees",repo.findAll());
        return "emp/showAll";
    }
    @GetMapping("employee/delete")
    public String deleteEmp(Model model,@RequestParam("id") int id) {
        repo.deleteById(id);
        model.addAttribute("employees",repo.findAll());
        return "redirect:/employee";
    }
    @RequestMapping(value = "employee/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateEmp( Employee employee) {
        repo.save(employee);
        return "redirect:/employee";
    }
//        @ExceptionHandler(EmployeeNotFound.class)
//    public String showError(Model model){
//        model.addAttribute("message","Not Found");
//        return "error";
//    }
}

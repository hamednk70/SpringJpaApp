package com.demisc.demo.controller;

import com.demisc.demo.model.Student;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import com.demisc.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentRepo repo;

    @Autowired
    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }
    @GetMapping("/enroll")
    public String newRegStudents(Model model){
        Student student = new Student();
        model.addAttribute(student);
        return "stu/enroll";
    }

    @ModelAttribute("sections")
    public List<String> initializeSections(){
        List<String> sections = new ArrayList<>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Reaserch");
        return sections;
    }
    @ModelAttribute("countries")
    public List<String> initializeCountries(){
        List<String> countries = new ArrayList<>();
        countries.add("INDIYA");
        countries.add("USA");
        countries.add("IRAN");
        countries.add("ITALYA");
        countries.add("Other");
        return countries;
    }
}

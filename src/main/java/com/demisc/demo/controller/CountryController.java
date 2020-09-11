package com.demisc.demo.controller;

import com.demisc.demo.exception.EmployeeNotFound;
import com.demisc.demo.model.Country;
import com.demisc.demo.model.Employee;
import com.demisc.demo.repository.BookRepo;
import com.demisc.demo.repository.CountryRepo;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/country")
public class CountryController {
    private CountryRepo repo;
    @Autowired
    public CountryController(CountryRepo repo) {
        this.repo = repo;
    }
    @GetMapping
    public String showPage(Model model,@RequestParam(defaultValue ="0") int pageNum){
        PageRequest page = PageRequest.of(pageNum,4);
        model.addAttribute("datas", repo.findAll(page).getContent());
        return "country/index";
    }
//    @GetMapping
//    public String showPagecon(Model model){
//        model.addAttribute("datas", repo.findAll());
//        return "country/index";
//    }
    @PostMapping("/saveCountry")
    public String saveCountry(Country country){
        repo.save(country);
        return "redirect:/";
    }
    @GetMapping("/deleteCountry")
    public String deleteCountry(@RequestParam int id){
        repo.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("{id}")
    public Country findOne(Model model, @PathVariable int id){
        Country country = repo.findById(id).get();
        model.addAttribute("country",country);
        return country;
    }

}

package com.demisc.demo.controller;

import com.demisc.demo.model.Book;
import com.demisc.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//@Controller
//public class MainController {
//    @Autowired
//    private BookRepo repo;
//    @Autowired
//    private BookController repo1;


//    @GetMapping("/")
//    public String init(HttpServletRequest request){
//        request.setAttribute("books",repo.findAll());
//        return "jsp/index";
//    }
//    @GetMapping("/")
//    public String init(Model request){
//        request.addAttribute("books",repo.findAll());
//        request.addAttribute("mode","BOOK_VIEW");
//        return "jsp/index";
//    }
//    @GetMapping("/updateBook")
//    public String init(HttpServletRequest request, @RequestParam int id){
//        request.setAttribute("book",repo.findById(id).get());
//        request.setAttribute("mode","BOOK_EDIT");
//        return "jsp/index";
//    }
//    @InitBinder
//    public void nitBinder(WebDataBinder dataBinder){
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
//    }
//
//    @PostMapping("/save")
//    public String saveBook(Book book, Model request ){
//        repo.save(book);
//        request.addAttribute("books",repo.findAll());
//        request.addAttribute("mode","BOOK_VIEW");
//        return "redirect:/";
//
//    }
//    @GetMapping("/newBook")
//    public String newBook(Model request ){
//        request.addAttribute("mode","NEW_BOOK");
//        return "jsp/index";
//    }
////    @GetMapping("/deleteBook")
////    public String deleteBook(@RequestParam int id, Model request ){
////        repo.deleteById(id);
////        request.addAttribute("mode","NEW_BOOK");
////        return "jsp/index";
////    }
//
//}

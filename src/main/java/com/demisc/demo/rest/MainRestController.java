package com.demisc.demo.rest;

import com.demisc.demo.controller.BookController;
import com.demisc.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MainRestController {
    @Autowired
    private BookController bookController;


//    @GetMapping("/findAllBooks")
//    public Collection<Book> getAllBooks(){
//        return bookController.findAllBooks();
//    }
}

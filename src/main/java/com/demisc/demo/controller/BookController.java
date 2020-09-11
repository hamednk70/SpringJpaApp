package com.demisc.demo.controller;

import com.demisc.demo.model.Book;
import com.demisc.demo.repository.BookRepo;
import com.demisc.demo.repository.JPA2EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepo repo;

    @GetMapping("/findAllBooks")
    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<>();
        for (Book book : repo.findAll()){
            books.add(book);
        }
        return books;

    }
    @GetMapping("/deleteBook")
    public void deleteBooks(@RequestParam int id){
        repo.deleteById(id);

    }
}

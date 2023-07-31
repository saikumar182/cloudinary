package com.example.cloudinary.controller;
import com.example.cloudinary.entity.Book;
import com.example.cloudinary.repo.BookRepo;
import com.example.cloudinary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/addBook")
    public ResponseEntity<String> newUserWithImage(@RequestParam("image") MultipartFile file, @RequestParam("bookname") String bookname, @RequestParam("authorname") String authorname) throws IOException {
        return ResponseEntity.ok(bookService.addNewUser(file, bookname, authorname));
    }

    @GetMapping("/booksList")
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

}

package com.shalom.learning.controller;

import com.shalom.learning.dto.BookDto;
import com.shalom.learning.entity.Book;
import com.shalom.learning.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> index() { return bookService.all(); }

    @PostMapping
    public Book store(@Valid @RequestBody BookDto body) { return bookService.create(body); }

    @GetMapping("/{id}")
    public ResponseEntity<Book> show(@PathVariable Long id)
    {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookDto body) {
        return bookService.update(id, body);
    }
}

package com.letoshi.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letoshi.biblioteca.domain.Book;
import com.letoshi.biblioteca.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping
        public List<Book> getAll() {
                List<Book> items = bookService.getAll();
                return items;
        }

        @GetMapping("{id}")
        public Book getById(@PathVariable("id") Long id) {
                return bookService.getById(id);
        }

        @PostMapping
        public Book create(@RequestBody Book item) {
                Book Book = bookService.create(item);
                return Book;
        }

        @PutMapping("{id}")
        public Book update(@PathVariable("id") Long id, @RequestBody Book item) {
                return bookService.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return bookService.delete(id);
        }
}
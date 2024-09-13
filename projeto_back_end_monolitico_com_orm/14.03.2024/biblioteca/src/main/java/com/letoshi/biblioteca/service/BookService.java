package com.letoshi.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letoshi.biblioteca.domain.Book;
import com.letoshi.biblioteca.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        try {
            List<Book> items = new ArrayList<>();
            bookRepository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    public Book create(Book Book) {
        return bookRepository.save(Book);
    }

    public Book update(Long id, Book item) {
        Optional<Book> existingItemOptional = bookRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            Book existingItem = existingItemOptional.get();
            existingItem.setName(item.getName());
            return bookRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            if (bookRepository.findById(id).isPresent()) {
                bookRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}

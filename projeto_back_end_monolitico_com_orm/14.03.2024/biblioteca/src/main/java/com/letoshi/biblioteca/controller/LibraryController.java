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

import com.letoshi.biblioteca.domain.Library;
import com.letoshi.biblioteca.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

        @Autowired
        private LibraryService libraryService;

        @GetMapping
        public List<Library> getAll() {
                return libraryService.getAll();
        }

        @GetMapping("{id}")
        public Library getById(@PathVariable("id") Long id) {
                return libraryService.getById(id);
        }

        @PostMapping
        public Library create(@RequestBody Library item) {
                return libraryService.create(item);
        }

        @PutMapping("{id}")
        public Library update(@PathVariable("id") Long id, @RequestBody Library item) {
                return libraryService.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return libraryService.delete(id);
        }
}
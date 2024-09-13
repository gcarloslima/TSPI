package com.letoshi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letoshi.biblioteca.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}

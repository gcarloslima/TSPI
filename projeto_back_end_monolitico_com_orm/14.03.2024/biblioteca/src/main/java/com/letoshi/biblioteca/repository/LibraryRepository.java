package com.letoshi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letoshi.biblioteca.domain.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    
}

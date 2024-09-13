package com.letoshi.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letoshi.biblioteca.domain.Library;
import com.letoshi.biblioteca.repository.LibraryRepository;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll() {
        try {
            List<Library> items = new ArrayList<Library>();
            libraryRepository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Library getById(Long id) {
        Optional<Library> Library = libraryRepository.findById(id);
        if (Library.isPresent()) {
            return Library.get();
        }
        return null;
    }

    public Library create(Library library) {
        return libraryRepository.save(library);
    }

    public Library update(Long id, Library item) {
        Optional<Library> existingItemOptional = libraryRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            Library existingItem = existingItemOptional.get();
            existingItem.setName(item.getName());
            return libraryRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            if (libraryRepository.findById(id).isPresent()) {
                libraryRepository.deleteById(id);
                return true;
            } else {
                return false;
            }   
        } catch (Exception e) {
            return false;
        }
    }

}

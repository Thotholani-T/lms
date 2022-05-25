package com.shams.lms.services;

import com.shams.lms.models.Librarian;
import com.shams.lms.repositories.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository LibrarianRepository;

    public List<Librarian> getAllLibrarians() {
        return LibrarianRepository.findAll();
    }

    //Add new Librarian to database
    public void save(Librarian Librarian) {
        LibrarianRepository.save(Librarian);
    }

    //get Librarian by id
    public Optional<Librarian> findById(long id) {
        return LibrarianRepository.findById(id);
    }

    public void delete(Long id) {
        LibrarianRepository.deleteById(id);
    }

    public void update(Librarian Librarian) {
        LibrarianRepository.save(Librarian);
    }
}

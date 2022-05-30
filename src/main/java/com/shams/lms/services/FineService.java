package com.shams.lms.services;

import com.shams.lms.models.Book;
import com.shams.lms.models.Fine;
import com.shams.lms.models.Librarian;
import com.shams.lms.repositories.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FineService {
    @Autowired
    private FineRepository fineRepository;

    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    //Add new book to database
    public void save(Fine fine) {
        fineRepository.save(fine);
    }

    public Optional<Fine> findById(long id) {
        return fineRepository.findById(id);
    }
}

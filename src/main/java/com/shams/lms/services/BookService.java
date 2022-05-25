package com.shams.lms.services;

import com.shams.lms.models.Book;
import com.shams.lms.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Add new book to database
    public void save(Book book) {
        bookRepository.save(book);
    }

    //get book by id
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }
}

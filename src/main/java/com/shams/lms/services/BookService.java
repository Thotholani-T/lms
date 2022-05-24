package com.shams.lms.services;

import com.shams.lms.models.Book;
import com.shams.lms.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}

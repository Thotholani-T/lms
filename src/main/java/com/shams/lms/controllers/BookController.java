package com.shams.lms.controllers;

import com.shams.lms.models.Book;
import com.shams.lms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> booksList = bookService.getAllBooks();
        model.addAttribute("books", booksList);
        return "books";
    }

    @PostMapping("/books/add")
    public String add(Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("book",bookService.getBookById(id));
        return "edit_book";
    }

    @PostMapping("/books/{id}")
    public String update(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/books/delete/{id}")
    public String delete(@ModelAttribute("book") Book book) {
        bookService.delete(book);
        return "redirect:/books";
    }
}

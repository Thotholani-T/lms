package com.shams.lms.controllers;

import com.shams.lms.models.Book;
import com.shams.lms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("books/findById")
    @ResponseBody
    public Optional<Book> findById(long id) {
        return bookService.findById(id);
    }

    @RequestMapping(value="/books/update", method =  {RequestMethod.PUT, RequestMethod.GET})
    public String update(Book book) {
        bookService.update(book);
        return "redirect:/books";
    }

    @RequestMapping(value="/books/delete", method =  {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}

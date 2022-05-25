package com.shams.lms.controllers;

import com.shams.lms.models.Librarian;
import com.shams.lms.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/librarians")
    public String listLibrarians(Model model) {
        List<Librarian> librariansList = librarianService.getAllLibrarians();
        model.addAttribute("librarians", librariansList);
        return "librarians";
    }

    @PostMapping("/librarians/add")
    public String add(Librarian librarian) {
        librarianService.save(librarian);
        return "redirect:/librarians";
    }

    @RequestMapping("librarians/findById")
    @ResponseBody
    public Optional<Librarian> findById(long id) {
        return librarianService.findById(id);
    }

    @RequestMapping(value="/librarians/update", method =  {RequestMethod.PUT, RequestMethod.GET})
    public String update(Librarian librarian) {
        librarianService.update(librarian);
        return "redirect:/librarians";
    }

    @RequestMapping(value="/librarians/delete", method =  {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(long id) {
        librarianService.delete(id);
        return "redirect:/librarians";
    }
}

package com.shams.lms.controllers;

import com.shams.lms.models.Book;
import com.shams.lms.models.Member;
import com.shams.lms.services.BookService;
import com.shams.lms.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private BookService bookService;

    @GetMapping("/members")
    public String listMembers(Model model) {
        List<Member> membersList = memberService.getAllMembers();
        model.addAttribute("members", membersList);
        return "members";
    }

    @PostMapping("/members/add")
    public String add(Member member) {
        memberService.save(member);
        return "redirect:/members";
    }

    @RequestMapping("members/findById")
    @ResponseBody
    public Optional<Member> findById(long id) {
        return memberService.findById(id);
    }

    @RequestMapping(value="/members/update", method =  {RequestMethod.PUT, RequestMethod.GET})
    public String update(Member member) {
        memberService.update(member);
        return "redirect:/members";
    }

    @RequestMapping(value="/members/delete", method =  {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(long id) {
        memberService.delete(id);
        return "redirect:/members";
    }

//    Memeber Actions
    @GetMapping("/catalogue")
    public String catalogue(Model model) {
        List<Book> booksList = bookService.getAllBooks();
        model.addAttribute("books", booksList);
        return "catalogue";
    }
}

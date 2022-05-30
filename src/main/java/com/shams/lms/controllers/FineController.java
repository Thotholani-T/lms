package com.shams.lms.controllers;

import com.shams.lms.models.Fine;
import com.shams.lms.models.Librarian;
import com.shams.lms.repositories.ReservationRepository;
import com.shams.lms.services.FineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FineController {
    private FineService fineService;
    private ReservationRepository reservationRepository;

    @GetMapping("/fines")
    public String listLibrarians(Model model) {
        List<Fine> finesList = fineService.getAllFines();
        model.addAttribute("fines", finesList);
        return "fines";
    }
}

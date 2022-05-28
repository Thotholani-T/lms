package com.shams.lms.controllers;

import com.shams.lms.models.Reservation;
import com.shams.lms.services.BookService;
import com.shams.lms.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/catalogue/reserve")
//    @ResponseBody
    public String reserve(Long id) {
        //setting dates
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = borrowDate.plusDays(7);

        var reservation = new Reservation();

        reservation.setBookId(bookService.findById(id).get().getId());
        reservation.setBorrowDate(borrowDate);
        reservation.setReturnDate(returnDate);
        reservation.setStatus("Reserved");

        reservationService.reserveBook(reservation);

        return "redirect:/catalogue";
    }
}

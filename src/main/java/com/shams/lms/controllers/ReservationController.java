package com.shams.lms.controllers;

import com.shams.lms.models.Book;
import com.shams.lms.models.Fine;
import com.shams.lms.models.Reservation;
import com.shams.lms.services.BookService;
import com.shams.lms.services.FineService;
import com.shams.lms.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private FineService fineService;

    @RequestMapping(value="/catalogue/reserve")
    public String reserve(Long id) {
        //setting dates
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = borrowDate.minusDays(7);

        Book bookSelected = bookService.findById(id).get();
        int numberOfCopiesAvailable = bookSelected.getCopies();

        if (numberOfCopiesAvailable > 0) {
            //Book is available and thus can be reserved
            numberOfCopiesAvailable--;
            bookSelected.setCopies(numberOfCopiesAvailable);
            var reservation = new Reservation();
            reservation.setBookId(bookSelected.getId());
            reservation.setBorrowDate(borrowDate);
            reservation.setReturnDate(returnDate);
            reservation.setStatus("Reserved");
            reservationService.reserveBook(reservation);
            return "redirect:/catalogue";
        }

        if (reservationService.findById(id).get().getStatus() == "Canceled" || reservationService.findById(id).get().getStatus() == "Returned") {
            bookSelected.setCopies(bookSelected.getCopies()+1);
            bookService.save(bookSelected);
        }
        return "redirect:/catalogue";
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        List<Reservation> reservationList = reservationService.getAllReservations();
        model.addAttribute("reservations", reservationList);

        for (int i = 0; i < reservationList.size(); i++) {
            if (LocalDate.now().isAfter(reservationList.get(i).getReturnDate())){
                reservationList.get(i).setStatus("Overdue");
                //notify the member of the book that their book is overdue

                //create a fine and add amount
                if (reservationList.get(i).getStatus() == "Overdue") {
                    Fine fine = new Fine();
                    fine.setReservationId(reservationList.get(i).getReservationId());
                    fine.setFee(20.0f);
                    fineService.save(fine);
                }
            }
        }
        return "reservations";
    }

    @RequestMapping(value="/reservations/approve")
    public String approve(Long id) {
        //setting dates
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = borrowDate.plusDays(7);

        Reservation reservation = reservationService.findById(id).get();

        reservation.setBorrowDate(borrowDate);
        reservation.setReturnDate(returnDate);
        reservation.setStatus("Borrowed");
        reservationService.reserveBook(reservation);

        return "redirect:/reservations";
    }

    @RequestMapping(value="/reservations/deny")
    public String deny(Long id) {
        //setting dates
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = borrowDate.plusDays(7);

        Reservation reservation = reservationService.findById(id).get();
        reservation.setBorrowDate(borrowDate);
        reservation.setReturnDate(returnDate);
        reservation.setStatus("Canceled");
        reservationService.reserveBook(reservation);

        return "redirect:/reservations";
    }

    @RequestMapping(value = "myReservations")
    public String myReservations(Model model) {
        List<Reservation> reservationList = reservationService.getAllReservations();
        model.addAttribute("reservations", reservationList);
        return "myReservations";
    }
}

package com.shams.lms.services;

import com.shams.lms.models.Reservation;
import com.shams.lms.repositories.BookRepository;
import com.shams.lms.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BookRepository bookRepository;

    public void reserveBook(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}

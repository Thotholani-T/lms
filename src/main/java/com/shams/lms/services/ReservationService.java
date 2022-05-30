package com.shams.lms.services;

import com.shams.lms.models.Book;
import com.shams.lms.models.Member;
import com.shams.lms.models.Reservation;
import com.shams.lms.repositories.BookRepository;
import com.shams.lms.repositories.MemberRepository;
import com.shams.lms.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(long id) {
        return reservationRepository.findById(id);
    }

    public void reserveBook(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}

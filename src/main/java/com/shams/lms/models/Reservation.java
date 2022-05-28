package com.shams.lms.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationId")
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book book;

    private Long bookId;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;
//    @ManyToOne
//    @JoinColumn(name = "libraryId", insertable = false, updatable = false)
//    private Member member;
}

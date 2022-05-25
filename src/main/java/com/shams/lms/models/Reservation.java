package com.shams.lms.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reservationId")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Book id;
    private Date borrowDate;
    private Date returnDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "libraryId", insertable = false, updatable = false)
    private Member member;

}

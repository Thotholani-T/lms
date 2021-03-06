package com.shams.lms.repositories;

import com.shams.lms.models.Book;
import com.shams.lms.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

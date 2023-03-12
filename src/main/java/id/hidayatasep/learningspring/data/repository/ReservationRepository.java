package id.hidayatasep.learningspring.data.repository;

import id.hidayatasep.learningspring.data.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Iterable<Reservation> findAllReservationByDate(Date reservationDate);


}

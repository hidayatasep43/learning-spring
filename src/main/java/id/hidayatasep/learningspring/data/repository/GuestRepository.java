package id.hidayatasep.learningspring.data.repository;

import id.hidayatasep.learningspring.data.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findByEmail(String email);

}

package id.hidayatasep.learningspring.data.util;

import id.hidayatasep.learningspring.data.Guest;
import id.hidayatasep.learningspring.data.Reservation;
import id.hidayatasep.learningspring.data.Room;
import id.hidayatasep.learningspring.data.repository.GuestRepository;
import id.hidayatasep.learningspring.data.repository.ReservationRepository;
import id.hidayatasep.learningspring.data.repository.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        try {
            Iterable<Reservation> reservations = this.reservationRepository.findAllReservationByDate(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01")
            );
            reservations.forEach(System.out::println);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }

}

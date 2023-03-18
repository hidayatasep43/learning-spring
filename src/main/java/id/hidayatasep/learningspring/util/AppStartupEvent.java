package id.hidayatasep.learningspring.util;

import id.hidayatasep.learningspring.business.ReservationService;
import id.hidayatasep.learningspring.business.RoomReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;

    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(
                dateUtils.createDateFromDateString("2022-01-01")
        );
        roomReservations.forEach(System.out::println);
    }

}

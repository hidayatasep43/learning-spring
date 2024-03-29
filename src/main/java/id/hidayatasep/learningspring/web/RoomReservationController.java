package id.hidayatasep.learningspring.web;

import id.hidayatasep.learningspring.business.ReservationService;
import id.hidayatasep.learningspring.business.RoomReservation;
import id.hidayatasep.learningspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservation(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(
                date
        );
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }
}

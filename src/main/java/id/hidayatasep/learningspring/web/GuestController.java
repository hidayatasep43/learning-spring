package id.hidayatasep.learningspring.web;

import id.hidayatasep.learningspring.data.Guest;
import id.hidayatasep.learningspring.data.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuest(@RequestParam(value = "email", required = false) String email, Model model) {
        List<Guest> guests;
        if (email == null) {
            guests = guestRepository.findAll();
        } else {
            guests = guestRepository.findByEmail(email);
        }
        model.addAttribute("guests", guests);
        return "guests";
    }
}
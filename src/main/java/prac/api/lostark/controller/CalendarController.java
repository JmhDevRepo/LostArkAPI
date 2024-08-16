package prac.api.lostark.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String getCalendar() {
        return "/calendar/all";
    }
}

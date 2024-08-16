package prac.api.lostark.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weekdungeon")
public class WeekdungeonController {

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String weekDungeonListGet() {
        return "/weekdungeon/weekdungeon";
    }
}

package prac.api.lostark.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/character")
public class CharacterController {

    @GetMapping({"/list", "/list/{characterName}"})
    @PreAuthorize("hasRole('USER')")
    public String characterListGet() {
        return "/character/characterlist";
    }

    @GetMapping("/{characterName}")
    @PreAuthorize("hasRole('USER')")
    public String character(@PathVariable String characterName, Model model) {
        model.addAttribute("characterName", characterName);
        return "/character/character";
    }
}


package prac.api.lostark.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public String index() {
        return "/index";
    }
}

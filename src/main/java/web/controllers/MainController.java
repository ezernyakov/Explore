package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @PostMapping
    public String add() {
        return "main";
    }

    @GetMapping("/error")
    public String error() {
        return "main";
    }
}

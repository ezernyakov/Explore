package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String code, Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/error")
    public String error(Map<String, Object> model) {
        return "main";
    }
}

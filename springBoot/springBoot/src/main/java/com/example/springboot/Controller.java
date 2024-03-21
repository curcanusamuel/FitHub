package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
// Main class
@RestController
public class Controller {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


}
package com.example.lineBot.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RobotController {
//你好呀
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String home(){
        return "Say hi to LineBot!";
    }
}

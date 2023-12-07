package com.edxm.interview;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldSender sender;

    public HelloWorldController(HelloWorldSender sender) {
        this.sender = sender;
    }

    @PostMapping("/test")
    public void hello() {
        sender.send("Hi CloudAMQP, this was fun!");
    }
}

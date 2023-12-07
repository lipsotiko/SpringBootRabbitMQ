package com.edxm.interview;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldSender sender;

    public HelloWorldController(HelloWorldSender sender) {
        this.sender = sender;
    }

    @PostMapping("/hello")
    public void hello(@RequestBody HelloWorld helloWorld) {
        sender.send(helloWorld);
    }
}

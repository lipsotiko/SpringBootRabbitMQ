package com.edxm.interview.receivers;

import com.edxm.interview.HelloWorld;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReciever {

    @RabbitListener(queues = "${edxm.direct.queue}")
    public void handleMessage(HelloWorld helloWorld) {
        System.out.println("Received <" + helloWorld + "> on DirectReciever");
    }
}

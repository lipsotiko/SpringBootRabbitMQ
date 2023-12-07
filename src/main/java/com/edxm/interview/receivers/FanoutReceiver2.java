package com.edxm.interview.receivers;

import com.edxm.interview.HelloWorld;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver2 {

    @RabbitListener(queues = "${edxm.fanout.queue-b}")
    public void handleMessage(HelloWorld helloWorld) {
        System.out.println("Received <" + helloWorld + "> on FooWorldReceiver 2");
    }

}

package com.edxm.interview.receivers;

import com.edxm.interview.HelloWorld;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    @RabbitListener(queues = "${edxm.fanout.queue-a}")
    public void handleMessage(HelloWorld helloWorld) {
        System.out.println("Received <" + helloWorld + "> on FooWorldReceiver");
    }

}

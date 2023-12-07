package com.edxm.interview;

import com.edxm.interview.configuration.ExamRabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldSender {

    private final RabbitTemplate template;
    private final ExamRabbitMqConfig examConfig;

    public HelloWorldSender(RabbitTemplate template,
                            ExamRabbitMqConfig examConfig) {
        this.template = template;
        this.examConfig = examConfig;
    }

    public void send(String helloWorld) {
        //This sends ONE message to the specified exchange with the routing must.match
        template.convertAndSend(examConfig.directExchangeName(), examConfig.routingKey, helloWorld);
    }
}

package com.edxm.interview.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMqConfig {

    @Value("${edxm.fanout.queue-a}")
    private String fanoutQueueA;

    @Value("${edxm.fanout.queue-b}")
    private String fanoutQueueB;

    @Value("${edxm.fanout.exchange}")
    private String fanoutExchange;

    @Bean
    Queue fanoutQueueA() {
        return new Queue(fanoutQueueA, false);
    }

    @Bean
    Queue fanoutQueueB() {
        return new Queue(fanoutQueueB, false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Binding bindFanoutExchangeToFanoutQueue() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindFanoutExchangeToFanoutQueue2() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    public String fanoutExchnage() {
        return fanoutExchange;
    }

}

package com.edxm.interview.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMqConfig {

    @Value("${edxm.direct.queue}")
    private String directQueue;

    @Value("${edxm.direct.exchange")
    private String directExchange;

    @Bean
    Queue queue() {
        return new Queue(directQueue, false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchangeName());
    }

    @Bean
    Binding bindDirectExchangeToDirectQueue() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("must.match");
    }

    public String directExchangeName() {
        return directExchange;
    }

}

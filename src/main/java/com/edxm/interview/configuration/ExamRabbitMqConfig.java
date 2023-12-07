package com.edxm.interview.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamRabbitMqConfig {
    public final String routingKey = "d21e138c-aba2-4f3a-a745-0e7ac7ab4881";

    @Bean
    Queue queue() {
        return new Queue("exam", true);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchangeName(), true, false);
    }

    @Bean
    Binding bindDirectExchangeToDirectQueue() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(routingKey);
    }

    public String directExchangeName() {
        return "exchange." + routingKey;
    }

}

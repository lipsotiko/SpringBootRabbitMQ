package com.edxm.interview.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMqConfig {

    @Value("${edxm.topic.queue-a}")
    private String topicQueueA;

    @Value("${edxm.topic.queue-b}")
    private String topicQueueB;

    @Value("${edxm.topic.exchange-a}")
    private String topicExchangeA;

    @Bean
    Queue topicQueueA() {
        return new Queue(topicQueueA, false);
    }

    @Bean
    Queue topicQueueB() {
        return new Queue(topicQueueB, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(exchangeA());
    }

    @Bean
    Binding bindingTopicAExchange() {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with("taxi.bar.#");
    }

    @Bean
    Binding bindingTopicBExchange() {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("foo.bar.#");
    }

    public String exchangeA() {
        return topicExchangeA;
    }

}

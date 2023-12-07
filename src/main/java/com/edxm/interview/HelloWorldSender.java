package com.edxm.interview;

import com.edxm.interview.configuration.DirectRabbitMqConfig;
import com.edxm.interview.configuration.FanoutRabbitMqConfig;
import com.edxm.interview.configuration.TopicRabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldSender {

    private final RabbitTemplate template;
    private final DirectRabbitMqConfig directConfig;
    private final TopicRabbitMqConfig topicConfig;
    private final FanoutRabbitMqConfig fanoutConfig;

    public HelloWorldSender(RabbitTemplate template,
                            DirectRabbitMqConfig directConfig,
                            TopicRabbitMqConfig topicConfig,
                            FanoutRabbitMqConfig fanoutConfig) {
        this.template = template;
        this.directConfig = directConfig;
        this.topicConfig = topicConfig;
        this.fanoutConfig = fanoutConfig;
    }

    public void send(HelloWorld helloWorld) {
        //This sends ONE message to the specified exchange with the routing must.match
        template.convertAndSend(directConfig.directExchangeName(), "must.match", helloWorld);

        //This message is sent but ignored by the consumer
        template.convertAndSend(directConfig.directExchangeName(), "does.not.match", helloWorld);

        //This sends ONE message to the specified exchange with the routing pattern foo.bar.#
        template.convertAndSend(topicConfig.exchangeA(), "foo.bar.baz", helloWorld);

        //This sends ONE message to the specified exchange with the routing pattern taxi.bar.#
        template.convertAndSend(topicConfig.exchangeA(), "taxi.bar.baz", helloWorld);

        // This sends 2 messages, one to each queue that is bond to the fanout exchange.
        template.convertAndSend(fanoutConfig.fanoutExchnage(), "ignored", helloWorld);
    }
}

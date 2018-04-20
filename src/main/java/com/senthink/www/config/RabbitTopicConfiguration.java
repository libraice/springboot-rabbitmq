package com.senthink.www.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lingcy on 2018/4/20.
 */
@Configuration
public class RabbitTopicConfiguration {

    private String topicQueueName = "topicQueue";
    private String topicQueueNameA = "topicQueueA";
    private String topicQueueNameB = "topicQueueB";

    private String topicQueueExchange = "topicQueueExchange";

    @Bean
    public Queue queue(){
        return new Queue(topicQueueName);
    }

    @Bean
    public Queue queueA(){
        return new Queue(topicQueueNameA);
    }

    @Bean
    public Queue queueB(){
        return new Queue(topicQueueNameB);
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange(topicQueueExchange);
    }

    @Bean
    Binding bind(){
        return  new Binding(topicQueueName, Binding.DestinationType.QUEUE,topicQueueExchange,"topic.*",null);
    }
    @Bean
    Binding bindA(){
        return  new Binding(topicQueueNameA, Binding.DestinationType.QUEUE,topicQueueExchange,"topic.#",null);
    }
    @Bean
    Binding bindB(){
        return  new Binding(topicQueueNameB, Binding.DestinationType.QUEUE,topicQueueExchange,"#",null);
    }

}

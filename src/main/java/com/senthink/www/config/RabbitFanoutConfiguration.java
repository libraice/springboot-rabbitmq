package com.senthink.www.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lingcy on 2018/4/20.
 */
@Configuration
public class RabbitFanoutConfiguration {
    private String fanoutQueueName = "fanout";
    private String fanoutQueueNameA = "fanoutA";

    private String fanoutExchangeName = "fanoutExchange";
    @Bean
    public Queue bean(){
        return new Queue(fanoutQueueName);
    }
    @Bean
    public Queue beanA(){
        return new Queue(fanoutQueueNameA);
    }

    @Bean
    public Exchange fanoutExchange(){
        return  new FanoutExchange(fanoutExchangeName);
    }

    @Bean
    public Binding binding(){
        return new Binding(fanoutQueueName, Binding.DestinationType.QUEUE,fanoutExchangeName,"",null);
    }
    @Bean
    public Binding bindingA(){
        return new Binding(fanoutQueueNameA, Binding.DestinationType.QUEUE,fanoutExchangeName,"",null);
    }
}

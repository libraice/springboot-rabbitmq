package com.senthink.www.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lingcy@senthink.com
 * @description $DESCRIPTION
 * @Date:Created $YEAR-$MON-19 16:17
 * @modified by:
 */
@Configuration
public class RabbitDirectConfiguration {


    private String directExchangeName = "directExchange";

    private String directQueueName = "direct";

    private String directQueueName1 = "direct1";

    private String routingKey = "direct1";

    @Bean
    public Queue queue(){
        return new Queue(directQueueName);
    }

    @Bean
    public Exchange  exchange(){
        return new DirectExchange(directExchangeName);
    }

    @Bean
    public Binding binding(){
        return new Binding(directQueueName, Binding.DestinationType.QUEUE,directExchangeName,routingKey,null);
    }

    @Bean
    public Queue queue1(){
        return new Queue(directQueueName1);
    }

    @Bean
    public Binding binding1(){
        return new Binding(directQueueName1, Binding.DestinationType.QUEUE,directExchangeName,directQueueName1,null);
    }



}

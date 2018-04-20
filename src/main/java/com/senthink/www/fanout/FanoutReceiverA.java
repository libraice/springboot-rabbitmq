package com.senthink.www.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lingcy on 2018/4/20.
 */
@Component
@RabbitListener(queues = "fanoutA")
public class FanoutReceiverA {

    @RabbitHandler
    public void handle(String message){
        System.out.println("扇形交换机 test fanout exchangeA");
    }
}

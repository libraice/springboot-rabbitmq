package com.senthink.www.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lingcy on 2018/4/20.
 */
@Component
public class TopicReceiver {



    @RabbitListener(queues = "topicQueue")
    @RabbitHandler
    public void handle(String message){
        System.out.println("topic 接收 routing_key topic.*" + message);
    }


    @RabbitListener(queues = "topicQueueA")
    @RabbitHandler
    public void handleA(String message){
        System.out.println("topic 接收 routing_key topic.#" + message);
    }

    @RabbitListener(queues = "topicQueueB")
    @RabbitHandler
    public void handleB(String message){
        System.out.println("topic 接收 routing_key #" + message);
    }


}

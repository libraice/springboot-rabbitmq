package com.senthink.www.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lingcy@senthink.com
 * @description $DESCRIPTION
 * @Date:Created $YEAR-$MON-19 17:43
 * @modified by:
 */
@Component
@RabbitListener(queues = "direct1")
public class DirectReceiver1 {


    @RabbitHandler
    public void direct(String message){
        System.out.println("DirectReceiver1 "+message);
    }


}

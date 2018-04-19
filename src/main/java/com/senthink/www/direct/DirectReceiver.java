package com.senthink.www.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lingcy@senthink.com
 * @description $DESCRIPTION
 * @Date:Created $YEAR-$MON-19 16:41
 * @modified by:
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void direct(String message){
        System.out.println(message);
    }

}

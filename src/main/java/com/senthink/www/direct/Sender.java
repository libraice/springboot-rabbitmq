package com.senthink.www.direct;

import com.senthink.www.common.Consts;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lingcy@senthink.com
 * @description $DESCRIPTION
 * @Date:Created $YEAR-$MON-19 16:31
 * @modified by:
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate  rabbitTemplate;


    public boolean send(){

        String message = "test direct exchange";
        rabbitTemplate.convertAndSend(Consts.directExchangeName,Consts.routingKey,message);

        return true;
    }
}

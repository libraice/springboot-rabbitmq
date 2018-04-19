package com.senthink.www;

import com.senthink.www.common.Consts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {


	@Autowired
	private AmqpTemplate rabbitTemplate;


	@Test
	public void send(){
		String message = "test direct exchange";
		rabbitTemplate.convertAndSend(Consts.directExchangeName,Consts.routingKey,message);

	}

}

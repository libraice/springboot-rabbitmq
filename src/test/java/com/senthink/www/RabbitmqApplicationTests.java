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
	public void sendDirect(){
		String message = "test direct exchange";
		rabbitTemplate.convertAndSend(Consts.directExchangeName,Consts.routingKey,message);

	}
	@Test
	public void sendFanout(){
		String message = "test fanout exchange";
		rabbitTemplate.convertAndSend(Consts.fanoutExchangeName,"",message);

	}
	@Test
	public void sendTopic(){
		String message = "test topic exchange";
		rabbitTemplate.convertAndSend(Consts.topicExchangeName,"topic.A.B","topicExchangeName.A.B");
		rabbitTemplate.convertAndSend(Consts.topicExchangeName,"topic.A","topic.A");
		rabbitTemplate.convertAndSend(Consts.topicExchangeName,"senthink.topic.A","senthink.topic.A");
	}

}

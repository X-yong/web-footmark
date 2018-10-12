package com.footmark.portal.controller;

import com.footmark.portal.config.RabbitmqConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/12 11:08
 */
@Component
@RabbitListener(queues = RabbitmqConfig.QUEUE)
public class ReceiveMsg {
  /*  @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitmqConfig.QUEUE+"3", durable = "true", autoDelete="true"),
                    exchange = @Exchange(value = RabbitmqConfig.EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitmqConfig.BIND_KEY)
    )*/
    public void receive(String content) {
        System.out.println("[ReceiveMsg-2] receive msg: " + content);
    }
}

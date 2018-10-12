package com.footmark.service.controller;

import com.footmark.service.config.RabbitmqConfig;
import com.web.common.footmark.User;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/12 11:08
 */
@Component
@RabbitListener(queues = RabbitmqConfig.QUEUE)
public class ReceiveMsg {
    @RabbitHandler
    public void receive(User content) {

        System.out.println("接收到消息: " + content.getName());
    }
}

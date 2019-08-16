package com.footmark.consume.footmark.controller.mq;

import com.web.common.footmark.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/12 11:08
 */
@Component
//@RabbitListener(queues = "test")
public class ReceiveMsg {
    //@RabbitHandler
    public void receive(User content) {

        System.out.println("接收到消息: " + content.getName());
    }
}

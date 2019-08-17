package com.footmark.consume.controller.mq;

import com.common.footmark.User;
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

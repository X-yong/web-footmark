package com.footmark.user.webuser.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/12 10:57
 */
@Configuration
public class RabbitmqConfig {

    // 队列名称
    public final static String QUEUE = "test";
    // 交换机名称
    public final static String EXCHANGE = "test_exchanges";
    // 绑定的值
    public static final String BIND_KEY = "spring-boot-bind-key";

    //定义队列
    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue(QUEUE,false);
    }

    //定义交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

   /* //定义绑定
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BIND_KEY );
    }*/


}

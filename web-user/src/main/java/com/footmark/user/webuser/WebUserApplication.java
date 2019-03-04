package com.footmark.user.webuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RefreshScope
@MapperScan("com.footmark.user.webuser.dao")
public class WebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUserApplication.class, args);
    }

}

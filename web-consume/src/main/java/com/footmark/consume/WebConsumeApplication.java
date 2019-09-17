package com.footmark.consume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableAsync
@ServletComponentScan
@MapperScan("com.footmark.consume.dao")
@EnableTransactionManagement
@SpringBootApplication
public class WebConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebConsumeApplication.class, args);
    }
}

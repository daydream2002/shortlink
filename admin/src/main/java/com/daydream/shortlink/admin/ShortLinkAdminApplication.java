package com.daydream.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author daydream
 * Description
 * Date 2024/12/30 16:40
 */
@SpringBootApplication
@MapperScan("com.daydream.shortlink.admin.dao.mapper")
@EnableDiscoveryClient
@EnableFeignClients("com.daydream.shortlink.admin.remote")
public class ShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkAdminApplication.class, args);
    }
}

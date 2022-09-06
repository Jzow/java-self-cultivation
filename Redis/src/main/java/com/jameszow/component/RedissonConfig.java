package com.jameszow.component;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public Redisson redissonSingle(){
        Config config = new Config();

        // 创建单机模式，single单机模式，还有Master/Slave主从，Sentinel哨兵模式，Cluster集群模式
        config.useSingleServer()
                // 地址必须使用redis:// 前缀
                .setAddress("redis://localhost:6379")
                .setPassword("123456")
                .setTimeout(3000);
        return (Redisson) Redisson.create(config);
    }
}

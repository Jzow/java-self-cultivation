package com.jameszow.service;

import com.jameszow.bean.SurvivalClamProcessor;
import com.jameszow.component.RedissonConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
public class RedissonService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    public String demo(String lockName){
        SurvivalClamProcessor survivalClamProcessor = null;
        // 定义守护线程
        Thread survivalThread = null;
        RLock rLock = redissonClient.getLock(lockName);
        try{
            Boolean flag = rLock.tryLock(30, TimeUnit.SECONDS);
            System.out.println(flag);
            if(flag){
                System.out.println(Thread.currentThread().getName()+"取得锁");
                survivalClamProcessor = new SurvivalClamProcessor(rLock, lockName, String.valueOf(Thread.currentThread().getId()), 2);
                survivalThread = new Thread(survivalClamProcessor);
                survivalThread.setDaemon(Boolean.TRUE);
                survivalThread.start();
                // store 为提前设置的key
                Object o = redisTemplate.getExpire("store");
                System.out.println(o);
                int store = Integer.valueOf(o.toString());
                if(store > 0){
                    System.out.printf("售出1，当前库存为%d\n",--store);
                }
                System.out.println(Thread.currentThread().getName());
            }
        }catch (Exception e){
            log.error("请求失败",e);
            return "请求失败";
        }finally {
            if (null != survivalClamProcessor){
                survivalClamProcessor.stop();
            }
            if (null != survivalThread){
                survivalThread.interrupt();
            }
            if (rLock.isLocked()){
                rLock.unlock();
                System.out.println("解锁成功");
            }else {
                System.out.println("未进行解锁，锁为空");
            }
            return "请求成功";
        }
    }
}

package com.jameszow.bean;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁的实体类
 * 该类实现了Runnable，无法交给spring容器进行管理，无法通过依赖注入的方式使用该类
 */
@Slf4j
public class SurvivalClamProcessor implements Runnable{

    private static final int REDIS_EXPIRE_SUCCESS = 1;

    private RLock rLock;

    private String key;

    private String value;

    private int lockTime;

    // 线程关闭标记
    private volatile Boolean signal;

    public SurvivalClamProcessor(RLock rLock, String key, String value, int lockTime){
        this.rLock = rLock;
        this.key = key;
        this.value = value;
        this.lockTime = lockTime;
        this.signal = Boolean.TRUE;
    }

    public void stop(){
        this.signal = Boolean.FALSE;
    }

    @Override
    public void run() {
        int waitTime = lockTime * 1000 * 2 / 3;
        while (signal){
            try {
                Thread.sleep(waitTime);
                System.out.println(Thread.currentThread().getName());
                if(rLock.tryLockAsync(lockTime, 30, TimeUnit.SECONDS, Long.parseLong(value)).get()){
                    if(log.isInfoEnabled()){
                        log.info("expandLockTime 成功，本次等待{}ms，将重置锁超时时间重置为{}s,其中key为{},value为{}"
                        ,waitTime, lockTime, key, value);
                    }
                } else {
                    if(log.isInfoEnabled()) {
                        log.info("expandLockTime 失败，将导致SurvivalClamConsumer中断");
                    }
                    this.stop();
                }
            } catch (InterruptedException e) {
                if(log.isInfoEnabled()){
                    log.info("SurvivalClamProcessor 处理线程被强制中断");
                }
            } catch (Exception e) {
                log.error("SurvivalClamProcessor run error", e);
            }
        }
        if (log.isInfoEnabled()) {
            log.info("SurvivalClamProcessor 处理线程已停止");
        }
    }
}

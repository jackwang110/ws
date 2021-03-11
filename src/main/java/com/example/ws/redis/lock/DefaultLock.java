package com.example.ws.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@Slf4j
@Component
public class DefaultLock implements Lock {
    public static final String LOCK = "lock";
    //默认锁过期时间30秒，后期优化做成可配置
    private static long DEFAULT_EXPIRE_TIME = 30L;
    @Autowired
    private RedisTemplate redisTemplate;
    private WatchDog watchDog;
    @Override
    public void lock() {
        while (!tryLock()){
            log.info("线程{}获取分布式锁失败",Thread.currentThread().getName());
        }


    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return redisTemplate.opsForValue().setIfAbsent(LOCK, UUID.randomUUID(), DEFAULT_EXPIRE_TIME, TimeUnit.SECONDS);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return redisTemplate.opsForValue().setIfAbsent(LOCK, UUID.randomUUID(), time, unit);
    }

    @Override
    public void unlock() {
        //业务流程结束，释放锁
        redisTemplate.delete(LOCK);
        //将watchdog线程停止
        watchDog.setBusinessDone(false);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

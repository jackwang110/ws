package com.example.ws.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Arrays;

public class RedisTemplateLock {
    private static String uuid = "uuid";
    private static int timeout = 1000;
    private static String LOCK_KEY = "redis";

    private static final Long RELEASE_SUCCESS = 1L;
    @Autowired
    private StringRedisTemplate template;
    private DefaultRedisScript<Long> redisScript;
    public boolean lock(String key,String value) {
        Long start = System.currentTimeMillis();

        for (; ; ) {
            //SET命令返回OK ，则证明获取锁成功
            Boolean lock = template.opsForValue().setIfAbsent(key, value);
            if (lock) {
                return true;
            }
            //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
            long l = System.currentTimeMillis() - start;
            if (l >= timeout) {
                return false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean unlock(String key, String value){
        //使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        Long result = template.execute(redisScript, Arrays.asList(key,value));
        //返回最终结果
        return RELEASE_SUCCESS.equals(result);


    }

    @Bean
    public DefaultRedisScript<Long> defaultRedisScript() {
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText("if redis.call('get', KEYS[1]) == KEYS[2] then return redis.call('del', KEYS[1]) else return 0 end");
        return defaultRedisScript;
    }
}

package com.example.ws.thread.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws Exception{
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 0; i < 7; i++) {
            int temp = i;
            new Thread(()->{
                count.countDown();
                System.out.println(Thread.currentThread().getName()+"==上完自习走人");
            },Country.foreCountry(i)).start();
        }
        count.await();
        System.out.println("关门才能走");
    }
}

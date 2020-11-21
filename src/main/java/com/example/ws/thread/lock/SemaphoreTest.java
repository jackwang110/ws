package com.example.ws.thread.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore= new Semaphore(3);
        for (int i = 0; i < 7; i++) {
            int temp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName()+"停车3秒走人");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}

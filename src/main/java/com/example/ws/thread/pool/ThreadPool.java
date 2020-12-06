package com.example.ws.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static int times = 100;

    public static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000);

    public static ExecutorService threadPool = new ThreadPoolExecutor(5,
            10,
            60,
            TimeUnit.SECONDS,
            arrayBlockingQueue,
            new ThreadPoolExecutor.DiscardOldestPolicy()
            );
    public static void useThreadPool(){
        Long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("说点什么吧...");
                }
            });
        }
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                Long end = System.currentTimeMillis();
                System.out.println(end - start);
                break;
            }
        }
    }
    public static void createNewThead(){
        Long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {

            new Thread() {
                public void run() {
                    System.out.println("说点什么吧1...");
                }
            }.start();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        useThreadPool();
        createNewThead();
    }

}

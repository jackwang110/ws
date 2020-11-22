package com.example.ws.thread.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDataSync{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            while (number == 0 ){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"="+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number != 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"="+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 */
public class ConditionSync {
    public static void main(String[] args) throws Exception{
        ShareDataSync data = new ShareDataSync();
        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    data.increment();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.decrement();
            }
        },"BB").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    data.increment();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"cc").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.decrement();
            }
        },"DD").start();
    }

}

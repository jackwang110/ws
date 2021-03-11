package com.example.ws.thread;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest extends Thread {
   @Override
    public void run(){
       System.out.println("运行线程1");
   }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest threadTest1 = new ThreadTest();
        threadTest.start();
        threadTest1.start();
        Lock lock = new ReentrantLock();
        lock.lock();
        // lock
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        list.add("1");

    }
}

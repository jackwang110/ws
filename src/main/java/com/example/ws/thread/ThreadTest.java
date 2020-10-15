package com.example.ws.thread;

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
    }
}

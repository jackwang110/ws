package com.example.ws.thread;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("运行线程2");
    }

    public static void main(String[] args) {
        RunnableTest test = new RunnableTest();
        RunnableTest test1 = new RunnableTest();
        Thread thread = new Thread(test);
        thread.start();
    }
}

package com.example.ws.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SomeCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("运行线程3");
        return null;
    }

    public static void main(String[] args) {
        Callable oneCallable = new SomeCallable();
//由Callable<Integer>创建一个FutureTask<Integer>对象：
        FutureTask oneTask = new FutureTask(oneCallable);
//注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
        //由FutureTask<Integer>创建一个Thread对象：
        Thread oneThread = new Thread(oneTask);
        oneThread.start();
    }
}

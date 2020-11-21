package com.example.ws.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier= new CyclicBarrier(7,()->{
            System.out.println("召唤神龙----");
        });
        for (int i = 0; i < 7; i++) {
            int temp = i;
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"==上完自习走人");
            },Country.foreCountry(i)).start();
        }

    }
}

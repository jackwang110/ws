package com.example.ws.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class BlockData{
    private static volatile boolean FLAG = Boolean.TRUE;
    AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue blockingQueue = null;

    public BlockData(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void myProduct() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+ "";
            retValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"失败");
                FLAG = Boolean.FALSE;

            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了");
    }

    public void myConsume() throws Exception{
        String retValue = null;
        while (FLAG){
            retValue = (String) blockingQueue.poll(2, TimeUnit.SECONDS);
            if(null == retValue || retValue.equalsIgnoreCase("")){
                FLAG = Boolean.FALSE;
                System.out.println(Thread.currentThread().getName()+"\t取出队列"+retValue+"失败");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t取出队列"+retValue+"成功");
            TimeUnit.SECONDS.sleep(2);
//            System.out.println(Thread.currentThread().getName()+"\t取出队列"+retValue+"失败");
        }
    }

    public void stop(){
        FLAG = Boolean.FALSE;
    }
}

public class BlockQueueDemo {
    public static void main(String[] args) {
        BlockData data =  new BlockData(new ArrayBlockingQueue(1));

        new Thread(()->{
            System.out.println("生产线程启动");
            try {
                data.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"生产线程").start();
        new Thread(()->{
            System.out.println("消费者启动");
            try {
                data.myConsume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"消费线程").start();

    }

}

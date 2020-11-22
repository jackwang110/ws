package com.example.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
//
     static Object lock = new Object();

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5};
//        int a = 8;
//        int[] ints = findByHash(arr, a);
//        System.out.println(Arrays.toString(ints));
        new Thread(()->{
            synchronized (lock){
            try {
                System.out.println(Thread.currentThread().getName()+"A进入");
                lock.wait();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
            }
            System.out.println(Thread.currentThread().getName()+"被唤醒");
            }
        },"AA").start();
        new Thread(()->{
             synchronized (lock){


                try {
                    System.out.println(Thread.currentThread().getName()+"B进入");
                    lock.notify();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                }
            }
        },"BB").start();
    }
    public static int[] find(int[] arr,int a){
        List<Integer> objects = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(a - arr[i] == arr[j]){

                    return new int[]{i,j};
                }
            }
        }


        return null;
    }

    public static int[] findByHash(int[] arr, int index){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int targetNum = index - arr[i];
            if(map.containsKey(targetNum)){
                return new  int[]{map.get(targetNum),i};
            }
            map.put(arr[i],i);
        }



        return null;
    }
}

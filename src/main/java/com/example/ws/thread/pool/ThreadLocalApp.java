package com.example.ws.thread.pool;

import java.util.Random;

public class ThreadLocalApp {
    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static void muti2() {
        int i[] = (int[]) threadLocal.get();
        i[1] = i[0] * 2;
        threadLocal.set(i);
    }

    public static void muti3() {
        int i[] = (int[]) threadLocal.get();
        i[2] = i[1] * 3;
        threadLocal.set(i);
    }

    public static void muti5() {
        int i[] = (int[]) threadLocal.get();
        i[3] = i[2] * 5;
        threadLocal.set(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    int start = new Random().nextInt(10);
                    int end[] = {0, 0, 0, 0};
                    end[0] = start;
                    threadLocal.set(end);
                    ThreadLocalApp.muti2();
                    ThreadLocalApp.muti3();
                    ThreadLocalApp.muti5();
                    //int end = (int) threadLocal.get();
                    System.out.println(end[0] + "  " + end[1] + "  " + end[2] + "  " + end[3]);
                    threadLocal.remove();
                }
            }.start();
        }
    }
}

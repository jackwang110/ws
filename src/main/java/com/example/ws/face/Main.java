package com.example.ws.face;

/**
 * 斐波拉契系列问题的递归和动态规划
 */
public class Main {
    public static int f(int n){
        if(n <= 2){
            return n;
        }
        return f(n-2)+f(n-3);
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(f(n));
    }
}

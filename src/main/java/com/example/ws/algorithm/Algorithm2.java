package com.example.ws.algorithm;

import java.util.Scanner;

public class Algorithm2 {
    public static void main(String[] args) {
        int n;
        System.out.println("输入个数：");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int rabbit = rabbit(n);
        System.out.println(rabbit);
    }
    public static int rabbit(int n){
        int t1,t2;
        if(n ==1 || n ==2){
            return 1;
        }else {
           t1 = rabbit(n-1);
           t2 = rabbit(n-2);
           return t1 + t2;
         }
    }
}

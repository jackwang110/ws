package com.example.ws.algorithm;

import java.util.Scanner;

public class Algorithm1 {
    public static void main(String[] args) {
        int res ,head ,foot;
        res = 0;
        System.out.println("鸡兔同笼问题：");
        System.out.println("输入头数：");
        Scanner scanner = new Scanner(System.in);
        head = scanner.nextInt();
        System.out.println("输入脚数：");
        Scanner scanner1 = new Scanner(System.in);
        foot = scanner1.nextInt();
        res = qiongJu(head, foot);
        if(res == 1){
            System.out.println("鸡的数量："+chichken+"兔的数量"+rabbit);
        }
    }
    static int chichken,rabbit;
    public static int qiongJu(int head,int foot){
        int res,i,j;
        res = 0;
        for ( i = 0; i < head; i++) {
            j = head - i;
            if(2*i + 4*j == foot){
                res = 1;
                chichken = i;
                rabbit = j;
            }
        }
        return res;
    }


}

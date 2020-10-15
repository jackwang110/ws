package com.example.ws.algorithm;

import java.util.HashMap;

public class Algorithm3 {
    public static void main(String[] args) {
        /*int n;
        System.out.println("输入个数：");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int rabbit = rabbit(n);
        System.out.println(rabbit);*/
       /* int[] nums = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<nums.length;i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Search(nums,5,0,nums.length-1));*/
        double PI = 0;
        int N = 60000;
        int sum = 0;
        double x, y;
        for(int i = 0; i < N; i++){
            x = Math.random();
            y = Math.random();
            if( (x*x + y*y) < 1)
                sum++;
        }
        System.out.println("PI= " + (double)4*sum/N);
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
    public static int Search(int[] num,int n,int left,int right) {
        int mid = (left + right) / 2;
        if(n == num[mid])
            return mid+1;			//若n等于当前中间元素则返回下标
        if(left<right) {			//如果left小于right，说明没有查找完
            if(n > num[mid])		//如果大于中间值，则从右半部查找
                return Search(num,n,mid+1,right);
            else					//否则从左半部查找
                return Search(num,n,left,mid-1);
        }
        return -1;					//right大于left，n不存在数组中，返回-1
    }

    public static int[] bubbleSort(int[] a){
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length -i ; j++) {
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
    public static int[] selectSort(int[] a){
        int index,temp;
        for (int i = 0; i < a.length -1; i++) {
            index = i;
            for (int j = i+1; j < a.length; j++) {
                    if(a[j] < a[index]){
                        index = j;
                    }
            }
            if(i != index){
               temp = a[i];
               a[i] = a[index];
               a[index] = temp;
            }
            new HashMap<>();

        }
        return a;

    }
    public static int[] insertionSort(int[] a){
        int i,j,t,h;
        for ( i = 1; i < a.length; i++) {
               t = a[i];
               j = i - 1;
               while (j > 0 && t < a[j]){
                    a[j+1] = a[j];
                    j--;
               }
               a[j+1] = t;
        }
        return a;
    }
}

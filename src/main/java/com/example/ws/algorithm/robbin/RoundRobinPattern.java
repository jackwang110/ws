package com.example.ws.algorithm.robbin;

public class RoundRobinPattern {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int index = 0; // 索引:指定起始位置
        for (int i = 0; i < 17; i++) {
            int nextIndex = (index + 1) % arr.length;
            index = nextIndex;
            System.out.println(arr[index] + " ,index=" + index);
        }

    }
}

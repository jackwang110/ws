package com.example.ws.algorithm;

public class Algorithm5 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

        mergeSort2Down(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
    public static void mergeSort2Down(int[] arr, int start, int end){
        if (arr == null || start >= end) {
            return;
        }

        //获取待排序列中间位置
        int mid = (start + end) / 2;

        //递归排序左边[start,mid]集合
        mergeSort2Down(arr, start, mid);
        //递归排序右边[mid+1,end]集合
        mergeSort2Down(arr, mid + 1, end);

        //合并左边与右边的有序集合
        merge(arr, start, mid, end);

    }
    public static void merge(int[] arr, int start, int mid, int end){
        //temp用于汇总2个有序集合的临时集合
        int[] temp = new int[end - start + 1];
        //第1个有序集合索引
        int i = start;
        //第二个有序集合索引
        int j = mid + 1;
        //临时集合索引
        int k = 0;

        //将2个有序集合，插入到临时集合temp中
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        //将temp中的数据放入arr集合中
        for (i = 0; i < k; i++) {
            arr[start + i] = temp[i];
        }
    }


}

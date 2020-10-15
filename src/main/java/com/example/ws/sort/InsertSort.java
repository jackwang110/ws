package com.example.ws.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,7,9,8};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
    protected static int[] sort(int[] nums){
        if(nums == null || nums.length <2){
            return nums;
        }
        for (int i = 0; i < nums.length -1; i++) {
            //当前值
            int curr = nums[i+1];
            //上一个数的指针
            int preIndex = i;
            //在数组中找到一个比当前遍历小的第一个数
            while (preIndex >= 0 && curr < nums[preIndex]){
                //把遍历大的数往后移
                nums[preIndex + 1] = nums[preIndex];
                //需要插入的数的下标往前移
                preIndex --;
            }
            //插入这个数的后面
            nums[preIndex+1] = curr;
        }
        return nums;
    }
}

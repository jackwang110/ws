package com.example.ws.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,7,9,8};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
    protected static int[] sort(int[] nums){
        if(nums == null || nums.length <2){
            return nums;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length -1 -i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}

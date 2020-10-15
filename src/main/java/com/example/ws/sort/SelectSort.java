package com.example.ws.sort;

public class SelectSort {
    public static void main(String[] args) {

    }
    protected static int[] sort(int[] nums){
        if(nums == null && nums.length <2){
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = nums[i];
                nums[minIndex] = temp;
                nums[i] = nums[minIndex];
            }
        }
        return nums;
    }
}

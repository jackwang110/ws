package com.example.ws.written.array;


import java.util.HashSet;
import java.util.Set;

/**
 * @author TommyYang on 2019-05-19
 */
//求两个数组的交集(https://leetcode-cn.com/problems/intersection-of-two-arrays/)
public class InterSection {

    //暂时没想到更好的解法，感觉解法效率有待提高。
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return new int[]{};
        }

        Set<Integer> set = new HashSet<Integer>(nums1.length);
        for (int i : nums1){
            set.add(i);
        }

        Set<Integer> res = new HashSet<Integer>(nums2.length);
        for (int i : nums2){
            if (set.contains(i)){
                res.add(i);
            }
        }

        int[] resArr = new int[res.size()];

        int index = 0;
        for(int i : res){
            resArr[index++] = i;
        }

        return resArr;
    }
    private int[] interSection2(int[] num1,int[] num2){
        if(num1 == null || num2 == null){
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>(num1.length);
        for (int i : num1
             ) {
            set.add(i);
        }
        Set<Integer> set1 = new HashSet<>(num2.length);
        for (int i : num2
        ) {
            if(set.contains(i)){

                set1.add(i);
            }
        }
        int[] resArr = new int[set1.size()];
        int index = 0;
        for(int i : set1){
            resArr[index++] = i;
        }
        return resArr;

    }

}

package com.xyx.DailyLeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate_217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    /**
     * 存在重复元素
     * 【算法】排序、哈希表
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        //【哈希表】
        /*if (nums == null || nums.length == 0 || nums.length == 1) return false;
        Set<Integer> set = new HashSet<>();
        //注：contains时间空间复杂度都太高
        for (int num : nums){
            if (!set.add(num)){
                return true;
            }
        }
        return false;*/

        //【排序】
        if (nums == null || nums.length == 0 || nums.length == 1) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}

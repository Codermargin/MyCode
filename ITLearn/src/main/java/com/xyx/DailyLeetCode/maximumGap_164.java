package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class maximumGap_164 {
    public static void main(String[] args) {

    }

    /**
     * 最大间距
     * 【算法】基数排序、桶排序、API
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxDis = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDis = Math.max(maxDis,nums[i+1] - nums[i]);
        }
        return maxDis;
    }
}

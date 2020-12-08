package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class searchRange_34 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 找寻数字最先出现与最后出现
     * 【算法】二分查找
     * 【时间复杂度】O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int[] res = {-1,-1};
        if (nums.length == 0 || nums == null) return res;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                //找到目标值
                //判定其最开始和最末尾的值
                int start = mid,end = mid;
                while (start >= 0 && start < nums.length && nums[start] == target){
                    res[0] = start;
                    start--;
                }
                while (end >= 0 && end < nums.length && nums[end] == target){
                    res[1] = end;
                    end++;
                }
                return res;
            }else if (nums[mid] > target){
                //从左区间去找
                right = mid - 1;
            }else {
                //从右区间去找
                left = mid + 1;
            }
        }
        return res;
    }
}

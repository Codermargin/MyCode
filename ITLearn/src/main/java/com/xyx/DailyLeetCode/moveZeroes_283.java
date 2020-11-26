package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class moveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动0
     * 时间复杂度 O(n)
     * 方法：双指针
     * 思路：右指针寻找非0元素，然后与left进行交换，之后left后移一位，继续去确定下一个位置
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //【Method1】
        //定义两个指针,left左边表示已经确定好位置的元素
        //right去遍历数组中剩下的元素
        /*int left = 0,right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            //向下一位移动
            right++;
        }*/
        //【Method2】
        //双指针j用来存储非0元素的个数，然后将非0元素都移动到最前面
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        //往后填入非0的元素
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

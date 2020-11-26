package com.xyx.CurExam;

import java.util.*;

/*[1,3,5,6] 5
2

[1,3,5,6] 2
1

[1,3,5,6] 7
4

[1,3,5,6] 0
0
*/
public class HuaWei {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //找到插入位置
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

package com.xyx.DailyLeetCode;

public class reversePairs_493 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        int i = reversePairs(nums);
        System.out.println(i);
    }

    /**
     * 翻转对
     * 【算法】归并排序
     * 【法一】
     * 时间复杂度O(n^2)
     * 【法二】
     * 思路：拆成两个数组，翻转对数目之和 = 两个子数组翻转对数目之和 + 左右端点分别位于两个子数组的翻转对数目
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public static int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }

            // 左序列进行排序、右序列也进行排序，这样
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ret;
        }
    }

}

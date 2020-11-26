package com.xyx.DailyLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 考点：桶排序
 */
public class allCellsDistOrder_1030 {
    public static void main(String[] args) {
        int R = 2;
        int C = 3;
        int r0 = 1;
        int c0 = 2;
        int[][] res = allCellsDistOrder(R, C, r0, c0);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }


    /**
     * lc-1030
     * 题意：返回目标格距离最近到最远格子的坐标位置
     *
     * @param R
     * @param C
     * @param r0 起始行坐标 r0
     * @param c0 起始列坐标 c0
     * @return
     */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        //【误区】考虑用TreeMap来存储 距离：坐标点的位置 ！× 需采用桶排序

        //【正解】
        //计算最大距离
        int maxDistance = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        //默认放入maxDistance个距离桶
        for (int i = 0; i <= maxDistance; i++) {
            bucket.add(new ArrayList<>());
        }
        //开始计算distance放入桶内
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dis = distance(r0,c0,i,j);
                //放入桶内
                bucket.get(dis).add(new int[]{i,j});
            }
        }
        int[][] res = new int[R*C][2];
        int idx = 0;
        for (int i = 0; i <= maxDistance; i++) {
            for(int[] nums : bucket.get(i)){
                res[idx++] = nums;
            }
        }
        return res;
        /*//错误方法
        int total = R * C;
        int[][] res = new int[total][2];
        int idx = 0;
        //暴力二重循环
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //开始计算坐标值，并赋入
                int rowAxis = Math.abs(r0 - i);
                int colAxis = Math.abs(c0 - j);
                res[idx][0] = rowAxis;
                res[idx][1] = colAxis;
                idx++;
            }
        }
        return res;*/

    }

    public static int distance(int r0, int c0, int i, int j) {
        return Math.abs(i - r0) + Math.abs(j - c0);
    }
}

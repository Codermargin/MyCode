package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class findMinArrowShots_452 {
    public static void main(String[] args) {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    /**
     * 打气球
     * 思路：【交并集】->【每一次计算后进行置换区间】
     * 【正确率】 30 /45
     * 思路2：对气球左右边界进行排序，之后再进行判定
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        //按气球的左边界进行排序
        Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);
        //获取最右边的气球
        int finalPoint = points[points.length - 1][0];
        int shootCnt = 1;
        for (int i = points.length - 1; i >= 0; i--) {
            //如果最后一个左边界不能够射到倒数第二个
            if (finalPoint > points[i][1]) {
                shootCnt++;
                finalPoint = points[i][0];
            }
        }
        return shootCnt;
        /*【区间交并集】不完全正确
        //维护一个气球爆炸数组
        boolean[] isBoom = new boolean[points.length];
        int shootCnt = 0;
        int tempStart;
        int tempEnd;
        //遍历points数组判断交并集
        for (int i = 0; i < points.length; i++) {
            if (!isBoom[i]) {
                shootCnt++;
                isBoom[i] = true;
                tempStart = points[i][0];
                tempEnd = points[i][1];
            } else {
                //isBoom = true,已经爆炸过，被添加到交并数组中
                continue;
            }
            for (int j = i + 1; j < points.length; j++) {
                if (isBoom[j]) continue; //如果当前节点已经被击穿过
                if (points[j][1] < tempStart || tempEnd < points[j][0]) {
                    //没有相交
                } else {
                    //区间相交，同一个弓箭可以射到
                    isBoom[j] = true;
                    //然后进行区间置换
                    tempStart = Math.max(tempStart, points[j][0]);
                    tempEnd = Math.min(tempEnd, points[j][1]);
                }
            }
        }
        return shootCnt;*/
    }
}

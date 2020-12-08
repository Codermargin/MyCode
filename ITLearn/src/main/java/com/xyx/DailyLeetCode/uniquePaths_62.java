package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class uniquePaths_62 {
    public static void main(String[] args) {
        int m = 3,n = 2;
        int i = uniquePaths(m, n);
        System.out.println(i);
    }

    static int totalMethod = 0;
    /**
     * 不同路径
     * 【算法】动态规划 √
     * 【算法】回溯算法 超时（栈溢出）
     * @param m 这个是列数
     * @param n 这个是行数
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        //1、填充行列
        Arrays.fill(arr[0],1);
        for (int i = 1; i < m; i++) {
            arr[i][0] = 1;
        }
        //2、DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
        //回溯超时(空间复杂度不够，栈溢出)
        /*backtrack(n, m, 0, 0);
        return totalMethod;*/
    }

    /**
     * 回溯算法
     * @return
     */
    public static void backtrack(int n,int m,int i,int j){
        //1、回溯退出条件(到达终点)
        if (i == n - 1 && j == m - 1){
            //方案+1
            totalMethod++;
            return;
        }
        if (i > n - 1 || j > m - 1){
            return;
        }
        //2、选择方案向右移动，向下移
        //2.1 向右移
        backtrack(n,m,i,j+1);
        //2.2 向下移
        backtrack(n, m, i+1, j);
    }
}

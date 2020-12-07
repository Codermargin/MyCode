package com.xyx.DailyLeetCode;

public class matrixScore_861 {
    public static void main(String[] args) {

    }

    /**
     * 翻转后矩阵的得分
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        //1、计算出A的行数列数
        int m = A.length;
        int n = A[0].length;
        int result = m * (1 << (n - 1));
        //2、遍历每一列，比较1和0个数，若0多则翻转，若1多则不翻转
        //遍历第二列开始
        for (int i = 1; i < n; i++) {
            //2.1 统计每一列的1个数
            int numOnes = 0;//计算0的个数
            //遍历每一列中的元素（按行移动）
            for (int j = 0; j < m; j++) {
                if (A[j][0] == 1) {
                    //不是翻转位
                    numOnes += A[j][i];
                } else {
                    //是翻转位
                    numOnes += 1 - A[j][i];
                }
            }
            //2.2 计算每一列的最大取值，并加到result
            int k = Math.max(numOnes, m - numOnes);
            result += k * (1 << (n - i -1));
        }
        return result;
    }
}

package com.xyx.DailyLeetCode;

import java.util.Arrays;

public class largestPerimeter_976 {
    public static void main(String[] args) {
        int[] A = {3,6,2,3};
        int res = largestPerimeter(A);
        System.out.println(res);
    }
    public static int largestPerimeter(int[] A) {
        if (A.length < 3) return 0;
        Arrays.sort(A);
        int last = A.length - 1;
        for (int i = last; i >= 2 ; i--) {
            if (A[i] < A[i - 1] + A[i -2]){
                return A[i] + A[i - 1] + A[i -2];
            }
        }
        return 0;
    }
}

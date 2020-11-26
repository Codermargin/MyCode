package com.xyx.RingCentralExam;

import java.text.DecimalFormat;
import java.util.Enumeration;

public class RingCentral_1 {
    public static void main(String[] args) {
        /*for (int i = 1; i <= 10; i++) {
            double pre = 0.001;
            String ef = getEf(pre);
            DecimalFormat df = new DecimalFormat(ef);
            System.out.println(df.format(sqrt2(i, pre)));
        }*/
        String num = "2";
        String pre = "0.001";
        String ef = getEf(Double.parseDouble(pre));
        DecimalFormat df = new DecimalFormat(ef);
        System.out.println(df.format(sqrt3(num, pre)));
    }

    public static String getEf(double pre) {
        int cnt = 0;
        while (pre < 1) {
            cnt += 1;
            pre *= 10;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("#.");
        for (int i = 0; i < cnt; i++) {
            sb.append("#");
        }
        return sb.toString();
    }

    //    public static double sqrt(int num, double pre) {
//        double left, right, mid, newMid;
//        left = 1;
//        right = num;
//        mid = (left + right) / 2;
//        do {
//            if (mid * mid < num) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//            newMid = mid;
//            mid = (right + left) / 2;
//        } while (abs(mid, newMid) > pre);
//        return mid;
//    }
//
//    public static double abs(double a, double b) {
//        if (a > b) return a - b;
//        else return b - a;
//    }
    public static double sqrt2(int num, double pre) {
        double left = 0, right = num;
        while (true) {
            double mid = left + (right - left) / 2;
            if (Math.abs(num / mid - mid) < pre) return mid;
            else if (num / mid > mid) left = mid + 1;
            else right = mid - 1;
        }
    }
    public static double sqrt3(String num,String pre){
        int N = Integer.parseInt(num);
        double p = Double.parseDouble(pre);
        double res = sqrt2(N,p);
        return res;
    }
}

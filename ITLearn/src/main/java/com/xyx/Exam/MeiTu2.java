package com.xyx.Exam;

import java.util.Scanner;

public class MeiTu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double height = sc.nextLong();
            double duration = sc.nextLong();
            getAns(height, duration);
        }
    }

    /**
     * 获得最终结果
     *
     * @param height
     * @param duration
     */
    public static void getAns(double height, double duration) {
        //输出no
        if (duration >= 3 * height) {
            System.out.println("no");
            return;
        }
        //相等
        if (height == duration) {
            System.out.println("1");
            return;
        }
        if (height > duration) {
            System.out.println("0");
            return;
        }
        //其余判定撞击地板几次
        int times = 0;
        while (duration > 0) {
            duration -= height;
            //路径刚好走完
            if (duration == 0){
                times++;
                break;
            }
            //路径走不完
            if (duration <= 0) {
                break;
            }
            height /= 2;
            //弹起
            times++;
            //弹起路径
            duration -= height;
        }
        System.out.println("" + times);
    }
}

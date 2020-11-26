package com.xyx.CurExam;
import java.awt.*;
/**
 *
 */
public class HuaWei2 {

    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC";
        String T = "ABC";
        String res = Ans(s, T);
        System.out.println(res);
    }

    public static String Ans(String s, String target) {
        if (s == null || target == null || target.length() > s.length()) {
            return "";
        }
        int[] num = new int[125];
        //记录target字符
        for (int i = 0; i < target.length(); i++) {
            num[target.charAt(i)]++;
        }
        //滑动窗口
        //1、end 后移动 ，start 往前
        int start = 0, end = 0, len = target.length();
        int left = 0, right = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (num[s.charAt(end++)]-- > 0) {
                len--;
            }
            //找到子字符串
            while (len == 0) {
                //记录最小的窗口
                if (end - start < right - left) {
                    left = start;
                    right = end;
                }
                if (num[s.charAt(start++)]++ == 0) {
                    len++;
                }
            }
        }
        //有包含过子字符串target过
        if (right != Integer.MAX_VALUE) {
            return s.substring(left, right);
        } else {
            return "";
        }
    }
}

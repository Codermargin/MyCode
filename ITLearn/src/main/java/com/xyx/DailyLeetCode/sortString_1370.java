package com.xyx.DailyLeetCode;

public class sortString_1370 {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        String s1 = sortString(s);
        System.out.println(s1);
    }

    /**
     * 上升下降字符串
     * 【算法】桶计数算法
     * @param s
     * @return
     */
    public static String sortString(String s) {
        //创建字母统计数组并赋值
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer result = new StringBuffer();
        while (result.length() < s.length()){
            //从小到大
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0){
                    result.append((char)(i + 'a'));
                    num[i]--;
                }
            }
            //从大到小
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0){
                    result.append((char)(i + 'a'));
                    num[i]--;
                }
            }
        }
        return result.toString();
    }
}

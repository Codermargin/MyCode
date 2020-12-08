package com.xyx.DailyLeetCode;

public class reorganizeString_767 {
    public static void main(String[] args) {
        String S = "abbabbaaab";
        String string = reorganizeString(S);
        System.out.println(string);
    }

    /**
     * 重构字符串
     * 【算法】贪心算法
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        // 出现次数最多的字符临界值
        // threshold = (length + 1) >> 1;
        //计算长度
        int len = S.length();
        char[] S_char = S.toCharArray();
        int[] alphaCount = new int[26];
        int max = 0;
        int maxCharIndex = -1;
        //定义阈值
        int threshold = (len + 1) >> 1;
        //统计每个字符出现的次数
        for (int i = 0; i < len; i++) {
            alphaCount[S_char[i] - 'a']++;
        }
        //找出出现最大的字符，及其出现的次数
        for (int i = 0; i < alphaCount.length; i++) {
            if (alphaCount[i] > max){
                max = alphaCount[i];
                maxCharIndex = i;
                //如果最多的字符超出阈值
                if (max > threshold){
                    return "";
                }
            }
        }
        //将最大的字符放入偶数位置
        int index = 0;
        char[] res = new char[len];
        while (alphaCount[maxCharIndex] -- > 0){
            res[index] = (char) (maxCharIndex + 'a');
            index += 2;
        }
        //放剩下的位置上的字符
        for (int i = 0; i < 26; i++) {
            while (alphaCount[i] -- > 0){
                //超出重置为1
                if (index >= len){
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return String.valueOf(res);
    }
}

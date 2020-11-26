package com.xyx.Exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MeiTu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int startLen = str.length();
        Map<Character, Integer> map = new LinkedHashMap<>();
        //原先字符
        char preChar = str.charAt(0);
        StringBuffer sb = new StringBuffer();
        //遍历字符并统计
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            //如果进行切换字符后
            if (preChar != c){
                sb.append(preChar);
                sb.append(map.get(preChar));
                map.remove(preChar);//移除
            }
            //重新命名前序字符
            preChar = c;
        }
        //抽离最后一个字符
        for (Character c : map.keySet()){
            sb.append(c);
            sb.append(map.get(c));
        }
        //统计
        String newStr = sb.toString();
        if (newStr.length() < startLen) {
            System.out.printf(newStr);
        }else {
            System.out.printf(str);
        }
    }
}

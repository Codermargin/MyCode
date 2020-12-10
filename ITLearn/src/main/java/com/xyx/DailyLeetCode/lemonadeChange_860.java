package com.xyx.DailyLeetCode;

import java.util.HashMap;
import java.util.Map;

public class lemonadeChange_860 {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        boolean flag = lemonadeChange(bills);
        System.out.println(flag);
    }

    /**
     * 柠檬水找零
     * 【算法】贪心算法 Map
     * 【算法】贪心算法 模拟（降空间） 提速
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for (int num : bills){
            if (num == 5){
                five++;
            }else if (num == 10){
                if (five < 1){
                    return false;
                }
                five--;
                ten++;
            }else if (num == 20){
                if (ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if (five > 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
        /*//1、初始化钱包
        Map<Integer,Integer> lemonMap = new HashMap<>();
        lemonMap.put(5,0);
        lemonMap.put(10,0);
        lemonMap.put(20,0);
        //2、遍历bills进行每个顾客的找零钱判断
        for (int b : bills){
            //2.1 如果5元直接放入钱包
            if (b == 5){
                lemonMap.put(b,lemonMap.get(b)+1);
            }
            //2.2 如果10元，则要找5元
            else if (b == 10){
                if (lemonMap.get(5) > 0){
                    lemonMap.put(b,lemonMap.get(b) + 1);
                    lemonMap.put(5,lemonMap.get(5) - 1);
                }else {
                    return false;
                }
            }
            //2.3 如果20元，则先找10+5，再去找5+5+5
            else if (b == 20){
                if (lemonMap.get(10) > 0 && lemonMap.get(5) > 0){
                    lemonMap.put(b,lemonMap.get(b) + 1);
                    lemonMap.put(10,lemonMap.get(10) - 1);
                    lemonMap.put(5,lemonMap.get(5) - 1);
                }else if (lemonMap.get(5) > 3){
                    lemonMap.put(b,lemonMap.get(b) + 1);
                    lemonMap.put(5,lemonMap.get(5) - 3);
                }else {
                    return false;
                }
            }
        }
        return true;*/
    }
}

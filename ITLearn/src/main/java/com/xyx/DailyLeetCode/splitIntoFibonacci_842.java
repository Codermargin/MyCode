package com.xyx.DailyLeetCode;

import java.util.ArrayList;
import java.util.List;

public class splitIntoFibonacci_842 {
    public static void main(String[] args) {
        String S = "11235813";
        List<Integer> integers = splitIntoFibonacci(S);
        System.out.println(integers);
    }

    /**
     * 将数组分成斐波那契数列
     * 【方法】回溯法
     *
     * @param S
     * @return
     */
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        //进行回溯
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    /**
     * 回溯函数
     * @param list 结果List
     * @param S 字符串S
     * @param length 字符串S的长度
     * @param index 当前遍历到的索引
     * @param sum 当前list中所有元素的和
     * @param prev 前向值
     * @return
     */
    public static boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        //1、回溯终止条件
        if (index == length){
            return list.size() >= 3;
        }
        long currLong = 0; //存取long值防止用int会溢出，判断不了是否超过最大值
        //2、遍历S进行求和值的运算，并考虑剪枝条件
        for (int i = index; i < length; i++) {
            //2.1 当遍历到首位为0
            if (i > index && S.charAt(index) == '0'){
                break;
            }
            //求和
            currLong = currLong * 10 + (S.charAt(i) - '0');
            //2.2 当求得的数值超过最大值时
            if (currLong > Integer.MAX_VALUE){
                break;
            }
            int curr = (int)currLong;
            //2.3 当当前求得的值大于前面两项的和
            if (list.size() >= 2){
                if (curr > sum){
                    return false;
                }else if (curr < sum){
                    continue;
                }
            }
            //2.4 进行回溯
            list.add(curr);
            if (backtrack(list,S,length,i + 1,prev + curr,curr)){
                //回溯成功
                return true;
            }else {
                //回溯失败，说明当前这个curr数不能用，应移除
                list.remove(list.size() - 1);
            }
        }
        //3、遍历所有的结果并不能返回
        return false;
    }
}

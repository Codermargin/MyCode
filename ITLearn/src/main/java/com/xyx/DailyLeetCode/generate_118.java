package com.xyx.DailyLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generate_118 {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows == 0) return resultList;
        //1、初始化第一次结果List
        resultList.add(Arrays.asList(1));
        numRows--;
        int preLayer = 0; //前层
        int curListSize = 2;

        //2、处理第二层之后的List
        while (numRows != 0){
            //【说明】处理子List,前后端数值不用处理都是1，中间数值进行处理即可
            //2.1 获得前一层的数据进行填充
            List<Integer> tempList = new ArrayList<>();//临时数组
            tempList.add(1);
            for (int i = 1; i < curListSize - 1; i++) {
                tempList.add(resultList.get(preLayer).get(i) + resultList.get(preLayer).get(i-1));
            }
            tempList.add(1);
            resultList.add(tempList);
            numRows--;
            curListSize++;
            preLayer++;
        }
        return resultList;
    }
}

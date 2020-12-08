package com.xyx.DailyLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leastInterval_621 {
    public static void main(String[] args) {
//        char[] tasks = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'D', 'D', 'D', 'E', 'F'};
        char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','E'};
        int n = 2;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }

    /*【构建大顶堆】
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });*/

    /**
     * 任务调度器-621
     * 【算法】贪心算法
     * 【自己做】不能全过 63/71
     * 【参考方法】贪心算法
     * 【参考链接】https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
            int[] buckets = new int[26];
            for(int i = 0; i < tasks.length; i++){
                buckets[tasks[i] - 'A']++;
            }
            Arrays.sort(buckets);
            int maxTimes = buckets[25];
            int maxCount = 1;
            for(int i = 25; i >= 1; i--){
                if(buckets[i] == buckets[i - 1])
                    maxCount++;
                else
                    break;
            }
            int res = (maxTimes - 1) * (n + 1) + maxCount;
            return Math.max(res, tasks.length);

        /*//1、统计task数组中字符的个数(用map会不会更好点。。考虑)
        int[] taskArr = new int[26];
        int totalTask = tasks.length;
        for (int i = 0; i < totalTask; i++) {
            taskArr[tasks[i] - 65]++;
        }
        int[] tempArr = Arrays.copyOf(taskArr, taskArr.length);
        Arrays.sort(tempArr);
        //补充：加入最大数
        int maxCount = 1;
        for (int i = 1; i < 25; i++) {
            if (taskArr[i] == taskArr[i - 1]) {
                maxCount++;
            } else
                break;
        }
        //2、找到最多出现的字符下标
        int maxIndex = findMaxIndex(taskArr);

        //3、通过List进行最大数字的填充，依次进行，最终计算总长度
        List<Character> list = new ArrayList<>();
        //3.1 先进行初始化填充，将最大的都填充进去
        while (taskArr[maxIndex]-- != 0) {
            list.add((char) (maxIndex + 65));
            totalTask--;//总长度标记进行递减
            //不足补空格
            if (taskArr[maxIndex] != 0) {
                for (int i = 0; i < n; i++) {
                    list.add(' ');
                }
            }
        }
        //3.2 继续找出最大的字符下标进行填充
        while (totalTask != 0) {
            //3.2.1 找最大下标
            maxIndex = findMaxIndex(taskArr);
            //3.2.2 进行填充
            for (int i = 0; i < list.size() && taskArr[maxIndex] != 0; i++) {
                if (list.get(i) == ' ') {
                    list.remove(i);
                    list.add(i, (char) (maxIndex + 65));
                    taskArr[maxIndex]--;
                    totalTask--;
                    i += n - 1;
                }
            }
            //进行补足
            while (taskArr[maxIndex] != 0) {
                list.add((char) (maxIndex + 65));
                taskArr[maxIndex]--;
                totalTask--;//总长度标记进行递减
                //不足补空格
                if (taskArr[maxIndex] != 0) {
                    for (int i = 0; i < n; i++) {
                        list.add(' ');
                    }
                }
            }
        }
        if (maxCount > n) {
            return tasks.length;
        } else {
            return list.size();
        }*/
    }

    /**
     * 找寻最大下标的函数
     *
     * @param taskArr
     * @return
     */
    public static int findMaxIndex(int[] taskArr) {
        int maxIndex = 0;
        for (int i = 0; i < taskArr.length; i++) {
            if (taskArr[maxIndex] < taskArr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

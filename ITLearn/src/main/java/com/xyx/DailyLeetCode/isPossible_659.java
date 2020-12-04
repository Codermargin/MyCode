package com.xyx.DailyLeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class isPossible_659 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] nums = {1,2,3,4,4,5};
        boolean res = isPossible(nums);
        System.out.println(res);
    }

    /**
     * 分割数组为连续的子序列
     * 【思路】哈希表+最小堆
     * 【时间复杂度】O(nlogn)
     * @param nums
     * @return
     */
    public static boolean isPossible(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        //遍历数组，对每个数组的末位x 和 前向长度preLen进行更新
        for(int num : nums){
            //1、创建新的优先队列
            if (!map.containsKey(num)){
                map.put(num,new PriorityQueue<>());
            }
            //2、判定当前map中是否包含了num - 1的元素
            if (map.containsKey(num - 1)){
                //2.1若有 进行更新
                //找到最小的长度并取出
                int preLen = map.get(num - 1).poll();
                //若num - 1 队列中已经没有preLen，则移除
                if (map.get(num - 1).isEmpty()){
                    map.remove(num - 1);
                }
                map.get(num).offer(preLen + 1);
            }else {
                //2.2若无 放入1
                map.get(num).offer(1);
            }
        }
        //3、遍历优先队列中的元素并进行判决，检查长度是否>3
        for (Integer key : map.keySet()){
            PriorityQueue<Integer> queue = map.get(key);
            int minLen = queue.peek();
            if (minLen < 3){
                return false;
            }
        }
        return true;
    }
}

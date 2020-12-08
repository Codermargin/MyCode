package com.xyx.DailyLeetCode;

public class canCompleteCircuit_134 {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int res = canCompleteCircuit(gas,cost);
        System.out.println(res);
    }

    /**
     * 加油站
     * 【算法】暴力-一次遍历
     * @param gas 汽油数组
     * @param cost 耗费数组
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //【官方题解】
        /*int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;*/
        //【暴力解法】
        int Len = gas.length;
        int curGas = 0;
        //遍历加油站
        for (int i = 0; i < Len; i++) {
            //如果第一次加的油泡不到下一个加油站,跳过当前加油站
            if (gas[i] < cost[i]){
                continue;
            }else {
                //第一次后汽油可以运作
                curGas = 0;
                int startIdx = i;
                int step = 0;
                for (int j = startIdx; j != startIdx || step != Len; j = (j+1) % Len) {
                    //补充当前格子的汽油，走下一步
                    curGas = curGas + gas[j] - cost[j];
                    //走下一步的汽油不够
                    if (curGas < 0){
                        break;
                    }
                    step++;
                }
                //判断是否回到起始位置
                if (step == Len){
                    return startIdx;
                }else {
                    continue;
                }
            }
        }
        return -1;

    }
}

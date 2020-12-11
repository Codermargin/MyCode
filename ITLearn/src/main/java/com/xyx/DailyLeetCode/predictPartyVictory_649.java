package com.xyx.DailyLeetCode;

public class predictPartyVictory_649 {
    public static void main(String[] args) {
        String senate = "DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR";
        String res = predictPartyVictory(senate);
        System.out.println(res);
    }

    /**
     * Dota2 参议院
     * 【算法】模拟（没用数据结构）
     *
     * @param senate
     * @return
     */
    public static String predictPartyVictory(String senate) {
        //1、添加统计参议员的量
        int preRcnt = 0;//前置有多少个天辉行使了权利
        int preDcnt = 0;//前置有多少个夜魇行使了权利
        int OneRoundRcnt = 0;//一轮过后的天辉个数
        int OneRoundDcnt = 0;//一轮过后的夜魇个数
        //创建布尔数组进行维护参议院是否有权利
        boolean[] dieFlags = new boolean[senate.length()];
        //2、循环遍历senate
        while (true) {
            OneRoundRcnt = 0;
            OneRoundDcnt = 0;
            for (int i = 0; i < senate.length(); i++) {
                //2.1 如果已经不能执行权利了，直接跳过
                if (dieFlags[i]) continue;
                //2.2 如果能执行权利的话
                char c = senate.charAt(i);
                //2.3 如果c是R
                if (c == 'R') {
                    preRcnt++;
                    //如果前置Dcnt大于0，意味着Rcnt需要出来抵消，将Dcnt抵消掉
                    if (preDcnt > 0) {
                        preRcnt--;
                        preDcnt--;
                        dieFlags[i] = true;
                    } else
                        //如果没有被抵消,证明在这一轮有效(存活)
                        OneRoundRcnt++;
                } else if (c == 'D') {
                    //2.4 如果c是D
                    preDcnt++;
                    if (preRcnt > 0) {
                        preDcnt--;
                        preRcnt--;
                        dieFlags[i] = true;
                    } else
                        OneRoundDcnt++;
                }
            }
            //2.5 每一轮过后，如果发现投票的都是自己阵营的，则宣布胜利
            if (OneRoundDcnt > 0 && OneRoundRcnt == 0){
                return "Dire";
            }
            if (OneRoundRcnt > 0 && OneRoundDcnt == 0){
                return "Radiant";
            }
        }
    }
}

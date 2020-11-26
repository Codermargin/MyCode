package com.xyx.RingCentralExam;
/*
public boolean boardGame(int[] board, int start)
        Sample I
        [2,0,2,1,2]
        3
        false
        Sample II
        [1, 1, 0, 2, 1, 4]
        4
        true
*/

public class Chess {
    public static void main(String[] args) {
        int[] board = {1, 1, 0, 2, 1, 4};
        int start = 4;
        System.out.println(boardGame(board, start));
    }
    public static boolean boardGame(int[] board,int start){
        //从0开始跳
        return dfs(board,start,0);
    }

    /**
     *
     * @param board 棋盘
     * @param start 开始位置
     * @param step 步数
     * @return
     */
    public static boolean dfs(int[] board,int start,int step){
        //退出条件
        if (start < 0 || start >= board.length) return false;
        //若跳的步数刚好超出数组维度
        if (step == board.length) return false;
        //跳到0的位置
        if (board[start] ==0) return true;
        //向右或者向左,只要有一个能跳到终点
        return dfs(board,start - board[start],step + 1) ||
                dfs(board,start + board[start], step + 1);
    }
}

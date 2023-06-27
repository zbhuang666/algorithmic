package com.zhs.zbhuang.fucking.动态规划;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class LeetCode322 {

    int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 递归添加备忘录
     */
    int[] memo;

    int coinChangeR(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dpr(coins, amount);
    }

    private int dpr(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if(memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin: coins) {
            int suitProblem = dp(coins, amount - coin);
            if(suitProblem == -1) continue;
            res = Math.min(res, suitProblem + 1);
        }
        //把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * 迭代
     * @param coins
     * @param amount
     * @return
     */
    private int coinChangeD(int[] coins, int amount) {
        int[] dp =new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i=0;i<dp.length;i++) {
            for (int coin:coins) {
                if(i - coin<0) {
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 :dp[amount];
    }

}

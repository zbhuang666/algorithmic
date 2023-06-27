package com.zhs.zbhuang.fucking.动态规划;

/**
 * 斐波拉比数列
 */
public class LeetCode509 {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    Integer fib(Integer n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private Integer dp(int[] memo, Integer n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    /**
     * 迭代
     *
     * @param n
     * @return
     */
    Integer fb(Integer n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 迭代优化 滚动table
     */
    Integer ffb(Integer n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}

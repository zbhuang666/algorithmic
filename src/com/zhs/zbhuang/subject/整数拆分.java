package com.zhs.zbhuang.subject;

/**
 * 343题：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积。
 */
public class 整数拆分 {

    /**
     * 数学
     * @param n
     * @return
     */
    static int integerPartition(int n) {
        if (n <= 3) return n - 1;
        int x = n / 3;
        int y = n % 3;
        if (y == 0) return (int) Math.pow(3, x);
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        return (int) Math.pow(3, x) * 2;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    static int integerPartition1(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        int max = integerPartition(10);
        int max = integerPartition1(10);
        System.out.println(max);
    }
}

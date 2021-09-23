package com.zhs.zbhuang.subject;

import java.util.Arrays;

/**
 * 第300题：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class 最长上升子序列 {

    static int maxRiseSubNum(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int max = maxRiseSubNum(nums);
        System.out.println(max);
    }
}

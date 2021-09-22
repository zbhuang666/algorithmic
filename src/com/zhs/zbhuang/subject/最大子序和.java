package com.zhs.zbhuang.subject;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 */
public class 最大子序和 {

    static int maxSubSum(int[] nums) {
        int len = nums.length;
        if(len > 0) {
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i=1;i<len;i++) {
                if(dp[i - 1] > 0) {
                    dp[i] = dp[i-1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
            }
            Arrays.sort(dp);
            return dp[len - 1];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubSum(a);
        System.out.println(max);
    }
}

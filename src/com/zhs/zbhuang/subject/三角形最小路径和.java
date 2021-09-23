package com.zhs.zbhuang.subject;

import java.util.Arrays;

/**
 * 第120题：给定一个三角形，找出自顶向下的最小路径和。
 */
public class 三角形最小路径和 {

    static int triangleMinimumPathSum(int[][] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        if (len == 1) return nums[0][0];
        for (int i = 1; i < len; i++) {
            int length = nums[i].length;
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j];
                } else if (j == length - 1) {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i][j];
                } else {
                    nums[i][j] = Math.min(nums[i - 1][j - 1], nums[i - 1][j]) + nums[i][j];
                }
            }
        }
        Arrays.sort(nums[len - 1]);
        return nums[len - 1][0];
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int min = triangleMinimumPathSum(nums);
        System.out.println(min);
    }
}

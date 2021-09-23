package com.zhs.zbhuang.subject;

/**
 * 第64题：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class 最小路径和 {

    static int minimumPathSum(int[][] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int length = nums[i].length;
            for (int j = 0; j < length; j++) {
                if (i == 0 && j != 0) {
                    nums[i][j] = nums[i][j - 1] + nums[i][j];
                } else if (j == 0 && i != 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j];
                } else if (i != 0 && j != 0) {
                    nums[i][j] = Math.min(nums[i - 1][j], nums[i][j - 1]) + nums[i][j];
                }
            }
        }
        return nums[len - 1][nums[len - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int min = minimumPathSum(nums);
        System.out.println(min);
    }
}

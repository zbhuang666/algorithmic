package com.zhs.zbhuang.abing;

/**
 * 不同路径：一个机器人位于一个 m x n 网格的左上角，起始点在下图中标记为“Start”。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”。
 * 问：总共有多少条不同的路径？
 */
public class 障碍物 {

    static int obstacle(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : 1;
                    continue;
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i][j - 1];
                    continue;
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i - 1][j];
                    continue;
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = arr[i][j] == 1 ? 0 : (dp[i][j - 1] + dp[i - 1][j]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int max = obstacle(arr);
        System.out.println(max);
    }

}

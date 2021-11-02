package com.zhs.zbhuang.abing;

import java.util.Arrays;

public class 矩阵填充 {
    public static int[][] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;
        int x = 0, y;
        while (left <= right && up <= down) {
            for (y = left; y <= right && avoid(left, right, up, down); y++) {
                result[up][y] = matrix[x][y];
            }
            y--;
            up++;
            for (x = up; x <= down && avoid(left, right, up, down); x++) {
                result[x][right] = matrix[x][y];            }
            x--;
            right--;
            for (y = right; y >= left && avoid(left, right, up, down); y--) {
                result[down][y] = matrix[x][y];
            }
            y++;
            down--;
            for (x = down; x >= up && avoid(left, right, up, down); x--) {
                result[x][left] = matrix[x][y];
            }
            x++;
            left++;
        }
        return result;
    }

    public static boolean avoid(int left, int right, int up, int down) {
        return up <= down && left <= right;
    }

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ints = spiralOrder(mat);
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
    }
}

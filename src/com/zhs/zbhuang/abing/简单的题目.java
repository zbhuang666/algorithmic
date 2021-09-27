package com.zhs.zbhuang.abing;

/**
 * 1...n的和
 */
public class 简单的题目 {
    static int sum(int n) {
        boolean b = n > 0 && ((n += sum(n - 1)) > 0);
        return n;
    }

    static int sums(int n) {
        return (int)((Math.pow(n,2)+n)) >> 1;
    }

    public static void main(String[] args) {
        int sum = sums(10);
        System.out.println(sum);
    }
}

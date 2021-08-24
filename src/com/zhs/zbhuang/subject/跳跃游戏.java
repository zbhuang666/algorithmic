package com.zhs.zbhuang.subject;

/**
 *55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 */
public class 跳跃游戏 {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMax = 0;
        for(int i=0;i<n;i++) {
            if(i<=rightMax) {
                rightMax = Math.max(rightMax,i+nums[i]);
                if(rightMax>=n-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}

package com.zhs.zbhuang.subject;

import java.util.Arrays;

public class 扑克牌中的顺子 {

    static boolean shunZiInPlayingCards(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int subs = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i + 1]) return false;
            subs += nums[i + 1] - nums[i];
        }
        return subs < len;
    }

    static boolean shunZiInPlayingCards1(int[] nums) {
        int[] arr = new int[14];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < 14; i++) {
            if (arr[i] > 1) return false;
        }
        int min = 1, max = 13;
        while (min < 14 && arr[min] == 0) min++;
        while (max >= 0 && arr[max] == 0) max--;
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        boolean b = shunZiInPlayingCards1(nums);
        System.out.println(b);
    }
}

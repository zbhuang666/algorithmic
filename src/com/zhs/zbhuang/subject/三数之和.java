package com.zhs.zbhuang.subject;
/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * [0,0,0,0]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int j = i+1;
            final int k = i;
            while(j + 1 < len) {
                if(nums[j] + nums[j+1] + nums[i] == 0 &&
                        !lists.stream().anyMatch(ls -> ls.contains(nums[k]) &&
                                ls.contains(nums[k+1]) && ls.contains(nums[k+2]))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[j+1]);
                    lists.add(list);
                }
                j++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        lists.stream().forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
}

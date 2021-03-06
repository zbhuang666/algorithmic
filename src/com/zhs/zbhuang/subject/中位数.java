package com.zhs.zbhuang.subject;

public class 中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
         否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的)
         getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
         **/
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
        int l = (m+n+1) / 2;
        int r = (m+n+2) / 2;
        // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
        if(l == r) return getKth(nums1, 0, nums2, 0, l);
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private  static double getKth(int[] nums1, int st1, int[] nums2, int st2, int k) {
        // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
        if(st1 > nums1.length-1) return nums2[st2 + k - 1];
        if(st2 > nums2.length-1) return nums1[st1 + k - 1];
        // 边界情况, k = 1 则返回两个数组中最小的那个
        if(k == 1) return Math.min(nums1[st1], nums2[st2]);
        // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(st1 + k/2 - 1 < nums1.length) mid1 = nums1[st1 + k/2 - 1];
        if(st2 + k/2 - 1 < nums2.length) mid2 = nums2[st2 + k/2 - 1];
        // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
        if(mid1 < mid2)
            return getKth(nums1, st1 + k/2, nums2, st2, k - k/2);
        else
            return getKth(nums1, st1, nums2, st2 + k/2, k - k/2);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6};
        int[] nums2 = new int[]{2,3,4,5,6,7,8};
        System.out.println(中位数.findMedianSortedArrays(nums1, nums2));
    }
}

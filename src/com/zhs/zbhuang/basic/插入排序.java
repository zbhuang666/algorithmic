package com.zhs.zbhuang.basic;

import java.util.Arrays;

public class 插入排序 {
    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for(int i = 1;i < len; i++) {
            preIndex = i -1;
            current = arr[i];
            while(preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = insertionSort(a);
        System.out.println(Arrays.toString(b));
    }
}

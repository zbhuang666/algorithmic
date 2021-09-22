package com.zhs.zbhuang.basic;

import java.util.Arrays;

/**
 * 按照步长插入排序
 */
public class 希尔排序 {
    public static int[] shellSort(int arr[]){
        int len = arr.length;
        for(int gap = len/2; gap > 0; gap = gap / 2) {
            for (int i = gap;i < len; i++) {
                int j = i;
                int current = arr[i];
                while(j - gap >= 0 && current < arr[j-gap]) {
                    arr[j] = arr[j - gap];
                    j = j -gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = shellSort(a);
        System.out.println(Arrays.toString(b));
    }
}

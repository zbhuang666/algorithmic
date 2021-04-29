package com.zhs.zbhuang;

import java.util.Arrays;

public class 选择排序 {
    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for(int j = i+1; j<len; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = selectionSort(a);
        System.out.println(Arrays.toString(b));
    }
}

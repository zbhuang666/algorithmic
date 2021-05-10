package com.zhs.zbhuang.basic;

import java.util.Arrays;

public class 冒泡排序 {
    public static int[] bubbleSort(int[] arr){
        int length = arr.length;
        for(int i = 0;i < length - 1;i++){
            for(int j = 0; j < length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = bubbleSort(a);
        System.out.println(Arrays.toString(b));
    }
}

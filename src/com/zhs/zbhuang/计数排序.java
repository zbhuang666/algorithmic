package com.zhs.zbhuang;

import java.util.Arrays;

public class 计数排序 {
    public static int[] countSort(int[] arr,int maxValue){
        int[] bucket = new int[maxValue+1];
        int sortIndex = 0;
        int arrLen = arr.length;
        int bucketLen = maxValue + 1;
        for (int i=0;i< arrLen; i++) {
            bucket[arr[i]]++;
        }
        for(int j =0;j < bucketLen; j++){
            while(bucket[j] > 0) {
                arr[sortIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = countSort(a, 85);
        System.out.println(Arrays.toString(b));
    }
}

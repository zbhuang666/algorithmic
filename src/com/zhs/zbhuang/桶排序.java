package com.zhs.zbhuang;

import java.util.Arrays;

public class 桶排序 {
    public static int[] bucketSort(int[] arr, int bucketSize){
        if(arr.length == 0) {
            return arr;
        }
        int maxValue = arr[0];
        int minValue = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<minValue){
                minValue=arr[i];
            } else if(arr[i] > maxValue) {
                maxValue=arr[i];
            }
        }
        int bucketCount = (maxValue-minValue)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];
        for(int i =0;i<arr.length;i++){
            int index = (arr[i] - minValue)/bucketSize;
            int[] bucket = buckets[index];
            bucket = Arrays.copyOf(bucket, bucket.length+1);
            bucket[bucket.length-1] = arr[i];
            buckets[index] = bucket;
        }
        int index =0;
        for (int[] bucket: buckets) {
            if(bucket.length == 0) {
                continue;
            }
            插入排序.insertionSort(bucket);
            for (int number: bucket) {
                arr[index++] = number;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = bucketSort(a, 5);
        System.out.println(Arrays.toString(b));
    }
}

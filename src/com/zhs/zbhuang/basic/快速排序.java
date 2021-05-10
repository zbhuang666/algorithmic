package com.zhs.zbhuang.basic;

import java.util.Arrays;

public class 快速排序 {
    public static int[] quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return arr;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
        return arr;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,28,1,3,27,18,81,4,39,85,72};
        int[] b = quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }

}

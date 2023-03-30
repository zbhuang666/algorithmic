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
        System.out.println(temp);
        System.out.println(Arrays.toString(arr));
        System.out.println(low);
        System.out.println(high);
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
        return arr;
    }

    public static int[] quickSort1(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low > high) {
            return arr;
        }
        i = low;
        j = high;
        temp = arr[low];
        while (i < j) {
            while (temp <= arr[j] && i<j) {
                j--;
            }
            while (temp >= arr[i] && i<j) {
                i++;
            }
            if(i<j) {
                t=arr[i];
                arr[i]=arr[j];
                arr[j] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort1(arr, low, j-1);
        quickSort1(arr, j+1, high);
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        int[] b = quickSort1(a, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }

}

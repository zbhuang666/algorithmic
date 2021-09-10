package com.zhs.zbhuang.abing;

import java.util.Arrays;

/**
 * 加一
 */
public class 加一 {

    public static int[] plusOne(int [] digits){
        for(int i =digits.length-1;i >= 0;i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,9,1};
        int[] ints = plusOne(a);
        System.out.println(Arrays.toString(ints));
    }
}

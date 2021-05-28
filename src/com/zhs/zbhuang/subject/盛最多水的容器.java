package com.zhs.zbhuang.subject;

public class 盛最多水的容器 {

    public static int maxArea(int[] height) {
        int total = 0;
        for(int i=0;i<height.length;i++) {
           for(int j=i+1;j<height.length;j++) {
               int area = (j-i) * (height[i] > height[j] ? height[j] : height[i]);
               if(area > total) {
                   total = area;
               }
           }
        }
        return total;
    }

    public static int getMaxArea(int[] height){
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

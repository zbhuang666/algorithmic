package com.zhs.zbhuang.subject;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 单调栈
 */
public class 每日温度 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                int preIndex = deque.pop();
                ans[preIndex] = i - preIndex;
            }
            deque.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] results = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(results));
    }

}

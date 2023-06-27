package com.zhs.zbhuang.sentinel;

import java.util.LinkedList;
import java.util.Random;

/**
 * 滑动窗口
 * 1 计数器算法是最简单的算法，可以看成是滑动窗口的低精度实现。
 * 2 滑动窗口由于需要存储多份的计数器（每一个格子存一份），所以滑动窗口在实现上需要更多的存储空间。
 * 3 也就是说，如果滑动窗口的精度越高，需要的存储空间就越大。
 */
public class SlidingTimeWindow {
    Long counter = 0L;
    LinkedList<Long> slots = new LinkedList<Long>();

    public static void main(String[] args) throws InterruptedException {
        SlidingTimeWindow timeWindow = new SlidingTimeWindow();
        new Thread(() -> {
            try {
                timeWindow.doCheck();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        while (true) {
            timeWindow.counter++;
            Thread.sleep(new Random().nextInt(15));
        }
    }

    private void doCheck() throws InterruptedException {
        while (true) {
            slots.addLast(counter);
            if (slots.size() > 10) {
                slots.removeFirst();
            }
            if ((slots.peekLast() - slots.peekFirst()) > 100) {
                System.out.println("被限流了");
                //修改限流标志为true
            } else {
                //修改限流标志为false
            }
            Thread.sleep(100);
        }
    }
}

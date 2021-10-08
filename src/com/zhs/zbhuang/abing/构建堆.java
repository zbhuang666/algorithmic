package com.zhs.zbhuang.abing;

import java.util.Arrays;

/**
 * 最小的k个数
 * 最小的k个数：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class 构建堆 {

    //建堆。对于一个还没维护过的堆，从他的最后一个节点的父节点开始进行调整。
    private static void buildHeap(int[] nums) {
        //最后一个节点
        int lastNode = nums.length - 1;
        //记住：父节点 = (i - 1) / 2  左节点 = 2 * i + 1  右节点 = 2 * i + 2;
        //最后一个节点的父节点
        int startHeapify = (lastNode - 1) / 2;
        while (startHeapify >= 0) {
            //不断调整建堆的过程
            heapify(nums, startHeapify--);
        }
    }

    //调整大顶堆的过程
    private static void heapify(int[] nums, int i) {
        //和当前节点的左右节点比较，如果节点中有更大的数，那么交换，并继续对交换后的节点进行维护
        int len = nums.length;
        if (i >= len)
            return;
        //左右子节点
        int c1 = ((i << 1) + 1), c2 = ((i << 1) + 2);
        //假定当前节点最大
        int max = i;
        //如果左子节点比较大，更新max = c1;
        if (c1 < len && nums[c1] > nums[max]) max = c1;
        //如果右子节点比较大，更新max = c2;
        if (c2 < len && nums[c2] > nums[max]) max = c2;
        //如果最大的数不是节点i的话，那么heapify(nums, max)，即调整节点i的子树。
        if (max != i) {
            swap(nums, max, i);
            //递归处理
            heapify(nums, max);
        }
    }

    //建堆。对于一个还没维护过的堆，从他的最后一个节点的父节点开始进行调整。
    private static void buildHeap1(int[] nums) {
        //最后一个节点
        int lastNode = nums.length - 1;
        //记住：父节点 = (i - 1) / 2  左节点 = 2 * i + 1  右节点 = 2 * i + 2;
        //最后一个节点的父节点
        int startHeapify = (lastNode - 1) / 2;
        while (startHeapify >= 0) {
            //不断调整建堆的过程
            heapify1(nums, startHeapify--);
        }
    }

    //调整小顶堆的过程
    private static void heapify1(int[] nums, int i) {
        //和当前节点的左右节点比较，如果节点中有更大的数，那么交换，并继续对交换后的节点进行维护
        int len = nums.length;
        if (i >= len)
            return;
        //左右子节点
        int c1 = ((i << 1) + 1), c2 = ((i << 1) + 2);
        //假定当前节点最小
        int min = i;
        //如果左子节点比较小，更新max = c1;
        if (c1 < len && nums[c1] < nums[min]) min = c1;
        //如果右子节点比较小，更新max = c2;
        if (c2 < len && nums[c2] < nums[min]) min = c2;
        //如果最大的数不是节点i的话，那么heapify(nums, max)，即调整节点i的子树。
        if (min != i) {
            swap(nums, min, i);
            //递归处理
            heapify(nums, min);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        int len = arr.length;
        if (k == len)
            return arr;

        //对arr数组的前k个数建堆
        int[] heap = new int[k];
        System.arraycopy(arr, 0, heap, 0, k);
        buildHeap(heap);

        //对后面较小的树建堆
        for (int i = k; i < len; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                heapify(heap, 0);
            }
        }
        //返回这个堆
        return heap;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{70, 45, 40, 20, 25, 35, 30, 10, 15};
        buildHeap(nums);
        int[] nums1 = new int[]{9, 18, 15, 25, 50, 30, 35, 34, 45};
        buildHeap1(nums1);
        int[] leastNumbers = getLeastNumbers(nums, 5);
        System.out.println(Arrays.toString(leastNumbers));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }
}

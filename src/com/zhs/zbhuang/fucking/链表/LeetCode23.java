package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并多个有序链表
 */
public class LeetCode23 {

   static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pd = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node: lists) {
            if(null != node) {
                pd.add(node);
            }
        }
        while (!pd.isEmpty()) {
            ListNode node = pd.poll();
            p.next = node;
            if(null != node.next) {
                pd.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode node = mergeKLists(lists);
        System.out.println(node);
    }
}

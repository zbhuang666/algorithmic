package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

/**
 * 找到倒数k个节点
 */
public class LeetCode22 {


    static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i=0;i<k;i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (null != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode fromEnd = findFromEnd(node, 2);
        System.out.println(fromEnd);
    }
}

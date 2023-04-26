package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

/**
 * 删除链表的第k个节点
 */
public class LeetCode19 {

    static ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = findFromEnd(head, k+1);
        node.next = node.next.next;
        return dummy.next;
    }

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
        ListNode curNode = removeNthFromEnd(node, 2);
        System.out.println(curNode);
    }
}

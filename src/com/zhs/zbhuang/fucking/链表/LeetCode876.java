package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

/**
 * 单链表的中点
 */
public class LeetCode876 {

    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode middleNode = middleNode(node);
        System.out.println(middleNode);
    }
}

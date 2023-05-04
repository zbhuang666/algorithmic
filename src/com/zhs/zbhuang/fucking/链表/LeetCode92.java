package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

public class LeetCode92 {

    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) {
            reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }
}

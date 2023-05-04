package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

public class LeetCode141 {

    static boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        add(5);
        System.out.println(first);
        System.out.println(hasCycle(first));
    }

    static ListNode first = new ListNode();

    static void add(int num) {
        for (int i=1;i<=num;i++) {
            ListNode node = new ListNode(i);
            if(i==1) {
                first = node;
                first.next = first;
            } else {
                ListNode tmp = first;
                while (tmp.next != first) {
                    tmp = tmp.next;
                }
                tmp.next = node;
                node.next = first;
            }
        }
    }
}

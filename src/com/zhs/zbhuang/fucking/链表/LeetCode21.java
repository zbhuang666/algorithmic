package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

/**
 * 21合并两个有序链表
 * p1 是为了处理l1每个节点
 * p2 是为了处理l2每个节点
 * p 是为了处理result每个节点
 */
public class LeetCode21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1),p = dummy,p1 = l1,p2=l2;
        while (null != p1 && null != p2) {
            if(p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
        }
        if(null != p1) {
            p.next = p1;
        }
        if(null != p2) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

}

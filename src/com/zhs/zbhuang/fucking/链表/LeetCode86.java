package com.zhs.zbhuang.fucking.链表;

import com.zhs.zbhuang.fucking.ListNode;

/**
 * 链表分割
 */
public class LeetCode86 {

    ListNode partition(ListNode head, int x) {
       ListNode dummy1 = new ListNode(-1);
       ListNode dummy2 = new ListNode(-1);
       ListNode p1 = dummy1, p2=dummy2,p=head;
       while (null != p) {
           if(p.val>x) {
               p2.next = p;
               p2 = p2.next;
           } else {
               p1.next = p;
               p1 = p1.next;
           }
           ListNode temp = p.next;
           p.next = null;
           p = temp;
       }
       p1.next = dummy2.next;
       return dummy1.next;
    }

    public static void main(String[] args) {
        
    }

}

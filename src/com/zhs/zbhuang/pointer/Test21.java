package com.zhs.zbhuang.pointer;


public class Test21 {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = l1, p2 = l2;
        while (null != l1 && null != l2) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (null != p1) {
            p.next = p1;
        }
        if (null != p2) {
            p.next = p2;
        }
        return dummy.next;
    }


}

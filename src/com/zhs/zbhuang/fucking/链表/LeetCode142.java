package com.zhs.zbhuang.fucking.链表;


import com.zhs.zbhuang.fucking.ListNode;

public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast,slow;
        fast = slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(null == fast || null == fast.next) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}

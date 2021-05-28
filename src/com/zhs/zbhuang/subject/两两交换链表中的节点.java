package com.zhs.zbhuang.subject;

public class 两两交换链表中的节点 {
    public static ListNode swapPairs(ListNode head) {
        ListNode next = head.next;
        acquireChangeListNode(head, next);
        return next;
    }

    static ListNode acquireChangeListNode(ListNode cur,ListNode next) {
        if(next == null) {
            return null;
        }
        ListNode nex = next.next;
        next.next = cur;
        cur.next = nex.next == null ? nex : acquireChangeListNode(nex, nex.next);
        return next;
    }

    public static void main(String[] args) {
        ListNode node8 = new ListNode(7);
        ListNode node7 = new ListNode(6,node8);
        ListNode node6 = new ListNode(5,node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = 两两交换链表中的节点.swapPairs(node2);
        System.out.println(node1);
    }

}


 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
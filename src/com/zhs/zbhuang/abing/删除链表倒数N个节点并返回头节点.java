package com.zhs.zbhuang.abing;

public class 删除链表倒数N个节点并返回头节点 {

    static class ListNode{
        public ListNode(ListNode next) {
            this.next = next;
        }

        public ListNode(ListNode next, String val) {
            this.next = next;
            this.val = val;
        }

        ListNode next;
        String val;
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(head);
        ListNode pre = new ListNode(null);
        ListNode cur = result;
        int i = 0;
        while(null != head) {
            if(i >= n) {
                pre = cur;
                cur = cur.next;
            }
            head = head.next;
            i++;
        }
        pre.next = pre.next.next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(null, "0");
        ListNode node2 = new ListNode(node1, "1");
        ListNode node3 = new ListNode(node2, "2");
        ListNode node4 = new ListNode(node3, "3");
        ListNode node5 = new ListNode(node4, "4");
        removeNthFromEnd(node5, 3);
    }
}

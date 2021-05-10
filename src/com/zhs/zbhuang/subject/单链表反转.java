package com.zhs.zbhuang.subject;

/**
 * 维护两个链表，老链表的头节点往老链表的尾节点移动
 */
public class 单链表反转 {
    public static void main(String[] args) {
        class Node {
            String name;
            Node next;
            public Node(String name, Node node) {
                super();
                this.name = name;
                this.next = node;
            }
        }

        Node e = new Node("e",null);
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        //关键代码开始
        Node pre = null;
        Node head = a;
        Node next = head.next;

        while(next != null){
            head.next = pre;
            pre = head;
            head = next;
            next = next.next;
        }
        head.next = pre;

        while(head != next){
            System.out.print(head.name + (head.next == null ? "" : "->"));
            head = head.next;

        }
    }
}

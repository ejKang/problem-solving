package com.ps.linkedlist;

import com.ps.base.ListNode;

public class DecimalValue {
    public static void main(String[] args) {
        ListNode child2 = new ListNode(1);
        ListNode child1 = new ListNode(0, child2);
        ListNode head = new ListNode(1, child1);
        DecimalValue.getDecimalValue(head);
    }
    public static int getDecimalValue(ListNode head) {
        int num = head.val; 
        while (head.next != null ) {
            num = num *2 + head.next.val;
            // num = (num << 1) | head.next.val;
            head = head.next;
        }
        System.out.println(num);
        return num;
    }

    
}

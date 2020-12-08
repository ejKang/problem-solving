package com.ps.linkedlist;

import com.ps.base.ListNode;

public class DeleteNode {
    
    public static void main(String[] args) {
        ListNode child2 = new ListNode(1);
        ListNode child1 = new ListNode(0, child2);
        ListNode head = new ListNode(1, child1);     
        System.out.println(head.val);   
        
        DeleteNode.deleteNode(child1);    
    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode nnext = null;
        if (next.next != null ) {
            nnext = next.next;
        }
        node.val = next.val;
        node.next = nnext;
    }
}

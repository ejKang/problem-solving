package com.ps.linkedlist;

import com.ps.base.ListNode;

public class RemoveElements_203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode rst = recursive(head, val);
        return rst;
    }

    private ListNode recursive(ListNode node, int val) {
        if (node == null) {
            return null;
        }
        ListNode next = recursive(node.next, val);

        if (node.val == val) {
            return next;
        } else {
            node.next = next;
            return node;
        }
    }

    public ListNode removeElements_2(ListNode head, int val) {

        ListNode temp = new ListNode(0, head);

        ListNode current = head;
        ListNode prev = temp;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return temp.next;

    }

}

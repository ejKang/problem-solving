package com.code.linkedlist;

import com.ps.base.ListNode;

public class DeleteNode_03 {

    public boolean deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            return false;
        }
        ListNode nxtNode = node.next;
        node.val = nxtNode.val;
        node.next = nxtNode.next;

        return true;

    }
}

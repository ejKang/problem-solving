package com.ps.linkedlist;

import com.ps.base.ListNode;

public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1Pointer != null && l2Pointer != null) {

            if (l1Pointer.val >= l2Pointer.val) {
                cur.next = l2Pointer;
                l2Pointer = l2Pointer.next;
                cur = cur.next;
            } else {
                cur.next = l1Pointer;
                l1Pointer = l1Pointer.next;
                cur = cur.next;
            }
        }

        while (l1Pointer != null) {
            cur.next = l1Pointer;
            l1Pointer = l1Pointer.next;
            cur = cur.next;
        }

        while (l2Pointer != null) {
            cur.next = l2Pointer;
            l2Pointer = l2Pointer.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}

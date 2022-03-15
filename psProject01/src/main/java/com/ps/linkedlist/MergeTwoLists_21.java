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

    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {

        ListNode tmp = new ListNode();
        ListNode head = tmp;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        if (list1 != null) {
            tmp.next = list1;
        }
        if (list2 != null) {
            tmp.next = list2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists_2_iter(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists_2_iter(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_2_iter(list1, list2.next);
            return list2;
        }
    }
}

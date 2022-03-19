package com.code.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.ListNode;

public class PrintKthToLast_02 {

    public int printKthToLast(ListNode node, int k) {

        if (node == null) {
            return 0;
        }
        int idx = printKthToLast(node.next, k) + 1;
        if (idx == k) {
            System.out.println(k + " th to last node is " + node.val);
        }
        return idx;
    }

    public ListNode kthToLast(ListNode node, int k) {
        Index idx = new Index();
        return kthToLast(node, k, idx);
    }

    private ListNode kthToLast(ListNode node, int k, Index idx) {
        if (node == null) {
            return null;
        }
        ListNode n = kthToLast(node.next, k, idx);
        idx.value = idx.value + 1;

        if (idx.value == k) {
            return n;
        }
        return node;
    }

    class Index {
        public int value = 0;
    }

    public ListNode kthToLast_iterate(ListNode node, int k) {
        ListNode p1 = node;
        ListNode p2 = node;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public ListNode kthToLast_map(ListNode node, int k) {
        Map<Integer, ListNode> map = new HashMap<>();

        int i = 1;
        while (node != null) {
            map.put(i, node);
            i++;
            node = node.next;
        }
        // current i = len +1

        return map.get(i - k);
    }
}

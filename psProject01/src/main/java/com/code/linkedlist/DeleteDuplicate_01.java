package com.code.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.ListNode;

public class DeleteDuplicate_01 {

    // time complexity - o(n)
    // space complexity - o(n)
    public void deleteDuplicate(ListNode node) {
        if (node == null) {
            return;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(node.val, node);
        while (node.next != null) {

            if (map.containsKey(node.next.val)) {
                node.next = node.next.next;
            } else {
                map.put(node.next.val, node.next);
                node = node.next;
            }
        }
    }

    // time complexity - o(n^2)
    // space complexity = o(1)
    public void deleteDuplicate2(ListNode node) {
        ListNode cur = node;

        while (cur != null) {
            ListNode runner = cur;

            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }
}

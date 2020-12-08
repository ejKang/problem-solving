package com.ps.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.ListNode;

public class MiddleNode {
    public static void main(String[] args) {

        ListNode child2 = new ListNode(1);
        ListNode child1 = new ListNode(2, child2);
        ListNode head = new ListNode(3, child1);
        ListNode temp = MiddleNode.middleNode(head);
        System.out.println(temp.val);
    }

    public static ListNode middleNode(ListNode head) {
        // O(N), space O(N)
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0 ;
        map.put(i, head);
        while (head.next != null) {
            map.put(++i, head.next);
            head = head.next;
        }
        int rst = (i+1) / 2;

        return map.get(rst);
        
    }
}

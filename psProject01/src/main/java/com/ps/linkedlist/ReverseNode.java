package com.ps.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.ListNode;

public class ReverseNode {
    
    public static void main(String[] args) {
        
    }

    public static ListNode reverseList(ListNode head) {
        // O(N), space O(N)
        if (head == null) {
            return head;
        }

        int i = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(i, head);
        while(head.next != null) {
            map.put(++i, head.next);
            head = head.next;
        }

        for (int j = i; j >=0; j--) {
            ListNode temp = map.get(j);
            if (j != 0) {
                temp.next = map.get(j-1);
            } else {
                temp.next = null;
            }
        }

        return map.get(i);
    }
}

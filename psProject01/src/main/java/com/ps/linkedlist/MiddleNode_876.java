package com.ps.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.ps.base.ListNode;

public class MiddleNode_876 {
    public static void main(String[] args) {
        ListNode child5 = new ListNode(6);
        ListNode child4 = new ListNode(5, child5);
        // ListNode child4 = new ListNode(5);
        ListNode child3 = new ListNode(4, child4);
        ListNode child2 = new ListNode(3, child3);
        ListNode child1 = new ListNode(2, child2);
        ListNode head = new ListNode(1, child1);
        MiddleNode_876 m = new MiddleNode_876();
        m.middleNode3(head);
    }

    public ListNode middleNode(ListNode head) {

        ListNode tmp = new ListNode(0, head);

        int cnt = 1;
        while (head.next != null) {
            cnt++;
            head = head.next;
        }

        cnt = (cnt + 1) / 2;

        int newCnt = 0;
        // tmp = tmp.next;
        while (newCnt != cnt) {

            tmp = tmp.next;
            newCnt++;
        }
        return tmp;
    }

    public ListNode middleNode2(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();
        int cnt = 1;
        while (head != null) {
            map.put(cnt, head);
            head = head.next;
            cnt++;
        }

        cnt = (cnt + 1) / 2;
        ListNode tmp = map.get(cnt);

        return tmp;
    }

    public ListNode middleNode3(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        int cnt = 1;
        while (fast != null) {
            fast = fast.next;
            if (cnt == 2) {
                cnt = 1;
                slow = slow.next;
            } else {
                cnt++;
            }

        }

        if (cnt == 2) {
            slow = slow.next;
        }
        return slow;
    }
}

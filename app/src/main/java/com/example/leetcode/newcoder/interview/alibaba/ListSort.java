package com.example.leetcode.newcoder.interview.alibaba;


import java.util.List;

public class ListSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode node = slow;
        while (fast != null && fast.next != null){
            node = slow;
            slow = slow.next;
            fast =fast.next.next;
        }
        if (node != null)
            node.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode phead = new ListNode(-1);
        ListNode cur = phead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        return phead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

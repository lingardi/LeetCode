package com.example.leetcode.newcoder.offer2;

import java.util.List;

public class ListSort {
    public ListNode listSort(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode[] nodes = getNodes(head);
        ListNode head1 = nodes[0];
        ListNode head2 = reverse(nodes[1]);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        if (head1.val <= head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        }else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode[] getNodes(ListNode head) {
        ListNode[] res = new ListNode[2];
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        int count = 1;
        while (head != null){
            if (count % 2 == 1){
                cur1.next = head;
                cur1 = cur1.next;
            }else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;

        res[0] = head1.next;
        res[1] = head2.next;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

package com.example.leetcode.newcoder.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode res = null;
        if (pHead1 == null || pHead2 == null)
            return res;
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            if (set.contains(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

package com.example.leetcode.newcoder.offer;

import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    /**
     * 尺取法，维护两个指针，第一个指针先走k-1步，然后两个指针一起移动
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <=0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k -1; i++){
            if (fast.next == null)
                return null;
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

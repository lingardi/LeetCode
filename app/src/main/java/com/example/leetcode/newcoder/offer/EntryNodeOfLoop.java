package com.example.leetcode.newcoder.offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast){
            return null;
        }
        while (pHead != slow){
            pHead = pHead.next;
            slow = slow.next;
        }
        return pHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

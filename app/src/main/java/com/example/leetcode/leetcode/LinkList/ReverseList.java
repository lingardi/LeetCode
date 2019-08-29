package com.example.leetcode.leetcode.LinkList;

import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return reverse(head, head, head.next);
    }

    /**
     *   递归输出: 1->2->3->4->5->NULL
     *             2->1->3->4->5->NULL
     *             3->2->1->4->5->NULL
     *             ...
     * @param head
     * @param first
     * @param target
     * @return
     */
    private ListNode reverse(ListNode head, ListNode first, ListNode target) {
        if (target == null)
            return head;
        first.next = target.next;
        ListNode temp = target.next;
        target.next = head;
        head = target;
        return reverse(head, first, temp);
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;
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
}

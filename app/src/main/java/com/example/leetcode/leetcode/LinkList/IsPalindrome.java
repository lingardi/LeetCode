package com.example.leetcode.leetcode.LinkList;

import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode pre2 = null;
        ListNode cur = slow;

        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre2;
            pre2 = cur;
            cur = temp;
        }

        while (head != null && pre2 != null){
            if (head.val != pre2.val)
                return false;
            head = head.next;
            pre2 = pre2.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

package com.example.leetcode.leetcode.LinkList.DoublePointer;

import java.util.HashMap;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转前半部分链表
        ListNode pre = null;
        while (head != slow){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        //奇数个节点时需要去除中点
        if (fast != null)
            slow = slow.next;


        while (slow != null){
            if (slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

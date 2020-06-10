package com.example.leetcode.leetcode.LinkList;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        int sum = 0;
        int count = 0;
        while (l1 != null && l2 != null){
            sum = l1.val + l2.val + count;
            count = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            sum = l1.val + count;
            l1.val = sum % 10;
            count = sum / 10;
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null){
            sum = l2.val + count;
            l2.val = sum % 10;
            count = sum / 10;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }

        if (count != 0){
            cur.next = new ListNode(count);
        }
        return node.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

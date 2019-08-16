package com.example.leetcode.leetcode.LinkList;


import java.util.List;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);
        ans = head;
        while (ans != null && ans.next != null){
            if (ans.val == ans.next.val){
                //清除野指针
                ListNode useless = ans.next;
                ans.next = useless.next;
                useless.next = null;
            }else {
                ans = ans.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

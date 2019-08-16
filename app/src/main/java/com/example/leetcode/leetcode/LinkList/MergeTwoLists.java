package com.example.leetcode.leetcode.LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null){
//            return l2;
//        }
//        if (l2 == null){
//            return l1;
//        }
//        ListNode root = new ListNode(-1);
//        ListNode pre = root;
//        while (l1!= null && l2 != null){
//            if (l1.val <= l2.val){
//                pre.next = l1;
//                l1 = l1.next;
//            }else {
//                pre.next = l2;
//                l2 = l2.next;
//            }
//            pre = pre.next;
//        }
//        pre.next = l1 == null? l2 : l1;
//        return root.next;
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}

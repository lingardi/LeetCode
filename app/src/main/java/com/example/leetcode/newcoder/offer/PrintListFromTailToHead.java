package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null)
            return ans;
        while (listNode != null){
            ans.add(0, listNode.val);
            listNode = listNode.next;
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

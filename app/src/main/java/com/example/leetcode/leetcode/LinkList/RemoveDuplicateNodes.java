package com.example.leetcode.leetcode.LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode q = null;
        while (p != null){
            if (!map.containsKey(p.val)){
                map.put(p.val, true);
                q = p;
                p = p.next;
            }else {
                p = p.next;
                q.next = p;
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

package com.example.leetcode.leetcode.LinkList.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 */
public class HasCycle {
    /**
     * Hash表，时间复杂度：O(n)，空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        int i =0;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (head != null){
            if (hashMap.keySet().contains(head))
                return true;
            hashMap.put(head, i);
            i++;
            head = head.next;
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

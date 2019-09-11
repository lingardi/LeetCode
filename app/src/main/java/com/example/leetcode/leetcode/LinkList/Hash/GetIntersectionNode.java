package com.example.leetcode.leetcode.LinkList.Hash;

import java.util.HashMap;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        HashMap<ListNode, Boolean> hashMap = new HashMap<>();
        while (headA != null){
            hashMap.put(headA, false);
            headA = headA.next;
        }
        while (headB != null){
            if (hashMap.containsKey(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针法，链表A的末节点指向链表B的头节点，链表B的末节点指向链表A的头节点，会相遇在相交节点
     * 总路程都等于本链 + 对方链表到相交节点的
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

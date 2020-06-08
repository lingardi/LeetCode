package com.example.leetcode.newcoder.leetcode;

import com.example.leetcode.leetcode.Tree.N_Tree.MaxDepth;

/**
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝。
 */
public class CopyRandomList {
    /**
     * 1. 复制原生链表
     * 2. 复制原生链表的random指针
     * 3. 分离原生链表和克隆链表
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        copy(head);
        random(head);
        return reList(head);
    }

    private RandomListNode reList(RandomListNode head) {
        RandomListNode copy = head.next;
        RandomListNode node = copy;
        head.next = copy.next;
        head = head.next;

        while (head != null){
            node.next = head.next;
            head.next = head.next.next;
            node = node.next;
            head = head.next;
        }

        return copy;
    }

    private void copy(RandomListNode head) {
        while (head != null){
            RandomListNode node = new RandomListNode(head.label);
            RandomListNode next = head.next;
            head.next = node;
            node.next = next;
            head = next;
        }
    }

    private void random(RandomListNode head) {
        while (head != null){
            RandomListNode node = head.next;
            if (head.random != null){
                RandomListNode random = head.random;
                node.random = random;
            }
            head = node.next;
        }
    }

    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { this.label = x; }
   };
}

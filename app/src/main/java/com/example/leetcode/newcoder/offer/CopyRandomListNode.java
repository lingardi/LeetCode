package com.example.leetcode.newcoder.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyRandomListNode {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return pHead;
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p1 != null){
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }

        while (p2 != null){
            if (p2.next != null){
                map.get(p2).next = map.get(p2.next);
            }else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}

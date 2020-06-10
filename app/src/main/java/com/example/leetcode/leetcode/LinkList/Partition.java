package com.example.leetcode.leetcode.LinkList;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class Partition {
    /**
     * 定义两个链表，分别存放比x小的和大于等于x的，最后将high接入low后面
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode lowhead = new ListNode(-1);
        ListNode highhead = new ListNode(-1);
        ListNode cur = head;
        ListNode low = lowhead;
        ListNode high = highhead;

        while (cur != null){
            if (cur.val < x){
                low.next = cur;
                low = low.next;
            }else {
                high.next = cur;
                high = high.next;
            }
            cur = cur.next;
        }
        high.next = null;
        low.next = highhead.next;
        return lowhead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

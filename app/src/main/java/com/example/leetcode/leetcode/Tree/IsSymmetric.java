package com.example.leetcode.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class IsSymmetric {
    /**
     * 递归，
     * 时间复杂度O(n),
     * 空间复杂度为 O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric1(IsSameTree.TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(IsSameTree.TreeNode p, IsSameTree.TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    /**
     * 迭代，单向队列, 队列中每两个连续的结点应该是相等的
     * 时间复杂度：O(n)
     * 空间复杂度为 O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric2(IsSameTree.TreeNode root) {
        Queue<IsSameTree.TreeNode> p = new LinkedList<>();
        ((LinkedList<IsSameTree.TreeNode>) p).add(root);
        ((LinkedList<IsSameTree.TreeNode>) p).add(root);

        while (! p.isEmpty()){
            IsSameTree.TreeNode p1 = p.poll();
            IsSameTree.TreeNode p2 = p.poll();

            if (p1 == null && p2 ==null)
                continue;
            if (p == null || p2 == null)
                return false;
            if (p1.val != p2.val)
                return false;
            ((LinkedList<IsSameTree.TreeNode>) p).add(p1.left);
            ((LinkedList<IsSameTree.TreeNode>) p).add(p2.right);
            ((LinkedList<IsSameTree.TreeNode>) p).add(p1.right);
            ((LinkedList<IsSameTree.TreeNode>) p).add(p2.left);
        }
        return true;
    }
}

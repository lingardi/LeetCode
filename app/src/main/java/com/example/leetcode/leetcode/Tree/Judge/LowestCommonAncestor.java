package com.example.leetcode.leetcode.Tree.Judge;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *                3
 *             /   \
 *           5      1
 *         /  \   /  \
 *        6   2  0    8
 *          /  \
 *        7    4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class LowestCommonAncestor {
    /**
     * 3种情况：
     * p、q的最小公共父节点为根结点
     * p、q均位于根结点的左子树或右子树上
     * p或q为根结点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }else if (left != null){
            return left;
        }else{
            return right;
        }
    }

    TreeNode ans;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        hasPorQ(root, p , q);
        return ans;
    }

    /**
     * 标志位法，最小公共父节点有三种情况：
     * 不存在
     * 左子树和右子树各有一点
     * 左子树或右子树有一点，节点本省有一点
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean hasPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        int left = hasPorQ(root.left, p , q) ? 1 : 0;
        int right = hasPorQ(root.right, p, q) ? 1 : 0;
        int mid = (root == q || root == p) ? 1 : 0;
        if (mid + left + right >= 2)
            ans = root;
        return (mid + left + right > 0);
    }



    /**
     * 父指针迭代
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        //找到P和Q, 循环后得到含有PQ节点及以上的父子映射关系
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();

            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();

        // 回溯，找到p的所有父节点
        while (p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        //如果p的父节点含有q，则最小公共父节点为q，如果不含q，则回溯q的所有父节点
        while (!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }


    public  class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}

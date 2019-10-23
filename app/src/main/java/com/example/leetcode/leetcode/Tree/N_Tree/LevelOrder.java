package com.example.leetcode.leetcode.Tree.N_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *         1
 *      /  | \
 *     3  2  4
 *   /  \
 *  5   6
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return res;
        levelorder(root, 0);
        return res;
    }

    private void levelorder(Node root, int depth) {
        if (root == null)
            return;
        if (depth > res.size() - 1){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(depth).add(root.val);
        for (Node node : root.children){
            levelorder(node, depth+1);
        }
    }

    public class Node  {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

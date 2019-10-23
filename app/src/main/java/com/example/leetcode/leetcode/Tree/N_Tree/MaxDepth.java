package com.example.leetcode.leetcode.Tree.N_Tree;

import android.support.v4.widget.ListViewAutoScrollHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *         1
 *      /  | \
 *     3  2  4
 *   /  \
 *  5   6
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children.size() == 0)
            return 1;
        List<Integer> heights = new ArrayList<>();
        for (Node node : root.children){
            heights.add(maxDepth(node));
        }
        return Collections.max(heights) + 1;
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

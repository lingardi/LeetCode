package com.example.leetcode.leetcode.Tree.N_Tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *         1
 *      /  / \
 *     3  2  4
 *   /  \
 *  5   6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Preorder {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return res;
    }

    private void preOrder(Node root) {
        if (root == null)
            return;
        res.add(root.val);
        for (Node node : root.children){
            preorder(node);
        }
    }

    public List<Integer> preorder2(Node root) {
        if (root == null)
            return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = 0; i < children.size(); i++){
                stack.push(children.get(children.size() - 1-i));
            }
        }
        return res;
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

package com.example.leetcode.leetcode.Tree.Levelorder;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        if (tree == null)
            return (ListNode[]) res.toArray();
        levelorder(res, tree, 0, new ArrayList<>());
        ListNode[] ans = new ListNode[res.size()];
        int i = 0;
        for (ListNode node : res){
            ans[i++] = node;
        }
        return ans;
    }

    private void levelorder(List<ListNode> res, TreeNode root, int depth, List<ListNode> tail) {
        if (root == null)
            return;
        ListNode cur = new ListNode(root.val);
        if (depth > res.size() - 1){
            res.add(cur);
            tail.add(cur);
        }else {
            tail.get(depth).next = cur;
            tail.set(depth, cur);
        }
        levelorder(res, root.left, depth + 1, tail);
        levelorder(res, root.right, depth + 1, tail);
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

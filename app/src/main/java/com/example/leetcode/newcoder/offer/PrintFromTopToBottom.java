package com.example.leetcode.newcoder.offer;
import java.util.ArrayList;
import java.util.List;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        levelOrder(ans, root, 0);
        for (int i = 0; i < ans.size(); i++){
            for (Integer c : ans.get(i)){
                res.add(c);
            }
        }
        return res;
    }

    private void levelOrder(ArrayList<List<Integer>> ans, TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > ans.size() - 1){
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        ans.get(depth).add(root.val);
        levelOrder(ans, root.left, depth +1);
        levelOrder(ans, root.right, depth +1);
    }

    public class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}

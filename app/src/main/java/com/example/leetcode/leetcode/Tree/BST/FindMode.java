package com.example.leetcode.leetcode.Tree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode {
    int maxTimes = 0;
    int curTimes = 0;
    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        //BST,只用考虑邻近父子节点
        if (pre != null && pre.val == root.val){
            curTimes++;
        }else {
            curTimes = 1;
        }
        if (curTimes == maxTimes){
            list.add(root.val);
        }else if (curTimes > maxTimes){
            maxTimes = curTimes;
            list.clear();
            list.add(root.val);
        }
        pre = root;
        inOrder(root.right);
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

package com.example.leetcode.leetcode.Tree.BST;

import com.example.leetcode.leetcode.Tree.Judge.IsSameTree;

/**
 * 插入并返回插入节点
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //1.判断根节点
        if(root == null){
            root = new TreeNode( val );
            return root;
        }

        //2.如果root比val大,接着往左边进行搜索,先判断左孩子是否为空
        //  为空就直接插入,不为空就进行递归,右边同理.
        if(root.val > val){//这里就表示当前data比val大,所以val在当前data的左子树上
            if(root.left == null){
                root.left =  new TreeNode(val);
                return root.left;
            }else{
                insertIntoBST( root.left,val );
            }
        }else{         //这里表示当前data比val小,即val应该在data的右子树上
            if(root.right == null){
                root.right =  new TreeNode(val);
                return root.right;
            }else{
                insertIntoBST(root.right, val );
            }
        }
        return null;
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

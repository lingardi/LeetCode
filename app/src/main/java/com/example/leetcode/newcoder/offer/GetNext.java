package com.example.leetcode.newcoder.offer;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return pNode;
        //当前节点有右子树，是当右子树的最左节点
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            //当前节点无右子树
            while (pNode.next != null){
                if (pNode.next.left == pNode){
                    return pNode.next;
                }else {
                    pNode = pNode.next;
                }
            }
        }
        return null;
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

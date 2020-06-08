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
                //当前节点是下个节点的左节点，直接返回
                if (pNode.next.left == pNode){
                    return pNode.next;
                }else {
                    //当前节点在右子树的最右（因为并没有右子树），需找到满足上一个条件的父节点
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

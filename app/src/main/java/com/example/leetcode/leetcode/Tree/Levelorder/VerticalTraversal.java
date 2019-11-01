package com.example.leetcode.leetcode.Tree.Levelorder;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 给定二叉树，按垂序遍历返回其结点值。
 *
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 *
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，
 * 我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 *
 * 如果两个结点位置相同，则首先报告的结点值较小。
 *
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 *
 *  
 *
 * 示例 1：
 *         3
 *        / \
 *       9   20
 *         /  \
 *        15   7
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
 * 然后，值为 9 的结点出现在 (-1, -1)；
 * 值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
 * 值为 20 的结点出现在 (1, -1)；
 * 值为 7 的结点出现在 (2, -2)。
 * 示例 2：
 *          1
 *        /  \
 *       2     3
 *     /  \   / \
 *    4   5   6  7
 * 输入：[1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
 * 然而，在报告 "[1,5,6]" 中，结点值 5 排在前面，因为 5 小于 6。
 *  
 *
 * 提示：
 *
 * 树的结点数介于 1 和 1000 之间。
 * 每个结点值介于 0 和 1000 之间。
 */
public class VerticalTraversal {
    /**
     * 用时5ms
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Node>> map = new TreeMap<>();
        helper(root,map,0,0);
        for(Map.Entry<Integer,List<Node>> entry:map.entrySet()){
            List<Integer> tmp=new ArrayList<>();
            for(Node node:entry.getValue()){
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }

    private void helper(TreeNode root, Map<Integer,List<Node>> map,int x,int y){
        if(root==null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x,new ArrayList<>());
        }
        int cur = root.val;
        List<Node> tmp=map.get(x);
        if(tmp.isEmpty()){
            tmp.add(new Node(cur,x,y));
        }else{
            int insertIndex=-1;
            for(int i=0;i<tmp.size();i++){
                Node node = tmp.get(i);
                if(node.y>y){
                    continue;
                }else if(node.y<y){
                    insertIndex=i;
                    break;
                }else if(cur<node.val){
                    insertIndex=i;
                    break;
                }
            }
            if(-1!=insertIndex){
                tmp.add(insertIndex,new Node(cur,x,y));
            }else{
                tmp.add(new Node(cur,x,y));
            }
        }
        map.put(x,tmp);
        helper(root.left,map,x-1,y-1);
        helper(root.right,map,x+1,y-1);
    }

    class Node {
        int val;
        int x;
        int y;
        public Node(int val,int x,int y){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}

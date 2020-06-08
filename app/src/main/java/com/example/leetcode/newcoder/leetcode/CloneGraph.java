package com.example.leetcode.newcoder.leetcode;

import com.example.leetcode.leetcode.Tree.N_Tree.MaxDepth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    //为了防止多次遍历同一个节点，避免陷入死循环，需要以hashmap跟踪已经复制的节点
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        //代表已经访问过
        if (map.containsKey(node)){
            return map.get(node);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbors : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbors));
        }
        return clone;
    }

    class UndirectedGraphNode {
       int label;
       ArrayList<UndirectedGraphNode> neighbors;
       UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
   }

}

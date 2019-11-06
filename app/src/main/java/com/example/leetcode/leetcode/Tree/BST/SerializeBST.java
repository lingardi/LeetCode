package com.example.leetcode.leetcode.Tree.BST;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，
 * 以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class SerializeBST {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val).append("-");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        String[] sb = data.split("-");
        return build(sb, 0, sb.length - 1);
    }

    /**
     * 遇到大于当前节点的值sb[i]，则sb[low + 1]到sb[i-1]为左子树，sb[i]到sb[hign]为右子树
     * @param sb
     * @param low
     * @param high
     * @return
     */
    private static TreeNode build(String[] sb, int low, int high) {
        if (low > high)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(sb[low]));
        //如果数组右侧没有更大的值，则后面所有元素都是左子树，右子树为空，同时此时左子树也是数组的完整边界
        int index = high + 1;
        for (int i = low + 1; i <= high; i++){
            if (Integer.valueOf(sb[i]) > root.val){
                index = i;
                break;
            }
        }
        root.left = build(sb, low + 1, index - 1);
        root.right = build(sb, index, high);
        return root;
    }

    public static class TreeNode  {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
        String res = serialize(root1);
        deserialize(res);
    }
}

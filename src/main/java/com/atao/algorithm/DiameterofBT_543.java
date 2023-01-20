package com.atao.algorithm;

/**
 * @Description (LeetCode-543) 二叉树的直径
 * @Author atao
 */
public class DiameterofBT_543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        /*递归计算当前节点左子树计算深度*/
        int left = maxDepth(root.left);
        /*递归计算当前节点右子树计算深度*/
        int right = maxDepth(root.right);

        /*取已有深度最大值以及当前节点左右子树深度和两者的最大值*/
        max = Math.max(max, left + right);

        /*返回以当前节点为根的树的深度*/
        return Math.max(left, right) + 1;
    }

}

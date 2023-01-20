package com.atao.algorithm;

/**
 * @Description (LeetCode-124) 二叉树中的最大路径和
 * @Author atao
 */
public class BTMaximumPathSum_124 {

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        /*递归计算当前节点通往左子树节点的节点值之和，节点值之和<0，抛弃*/
        int left = Math.max(0, maxPathDown(node.left));
        /*递归计算当前节通往右子树节点的节点值之和，节点值之和<0，抛弃*/
        int right = Math.max(0, maxPathDown(node.right));

        /*取已有最大值以及“当前节点值和左右子树节点值之和的和”两者的最大值*/
        maxValue = Math.max(maxValue, left + right + node.val);

        /*返回以当前节点为根的树的节点值之和*/
        return Math.max(left, right) + node.val;
    }

}

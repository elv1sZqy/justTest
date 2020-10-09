package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2020/9/30
 * @description :给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Test_110 {
    /**
     * 思路 :  入参就是一个二叉树, 只需要判断就行..
     * 暴力法就是计算两边的最深的层数查出来, 然后做一个计算. 看差值是不是大于一
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[1,2,3,4,5,null,6,7]");
        System.out.println(solution.isBalanced(treeNode));
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (null == root) {
                return true;
            }

            int rightDeepFloor = getDeepFloor(root.right, 1);
            int leftDeepFloor = getDeepFloor(root.left, 1);
            if (rightDeepFloor < 0 || leftDeepFloor < 0) {
                return false;
            }
            return Math.abs(rightDeepFloor - leftDeepFloor) < 2;
        }

        private int getDeepFloor(TreeNode root, int floot) {
            if (root == null || floot < 0) {
                return floot;
            }
            TreeNode right = root.right;
            TreeNode left = root.left;
            if (right == null && left == null) {
                return floot;
            }
            int rightFloot = 0;
            int leftFloot = 0;
            int nextFloot = ++floot;

            if (right != null) {
                rightFloot = getDeepFloor(right, nextFloot);
            }

            if (left != null) {
                leftFloot = getDeepFloor(left, nextFloot);
            }

            if (Math.min(leftFloot, rightFloot) < 0 || Math.abs(rightFloot - leftFloot) > 1) {
                return -1;
            }
            return Math.max(leftFloot, rightFloot);
        }
    }
}

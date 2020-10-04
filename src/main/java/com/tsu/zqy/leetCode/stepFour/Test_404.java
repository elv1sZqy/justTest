package com.tsu.zqy.leetCode.stepFour;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2019/11/27
 * @description :
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_404 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[3,9,20,null,null,15,7]");
        System.out.println(new Test_404().sumOfLeftLeaves(treeNode));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return getSumOfLeftLeaves(root, false);
    }

    private int getSumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (null == root) {
            return 0;
        }
        if (root.right == null && root.left == null && isLeft) {
            return root.val;
        }
        return getSumOfLeftLeaves(root.right, false) + getSumOfLeftLeaves(root.left, true);
    }

   /* public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return fun(root);

    }*/

    private int fun(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int i = fun(root.left);
        TreeNode right = root.right;
        if (right == null || (right.left == null && right.right == null)) {
            return i + 0;
        }
        int i1 = fun(root.right);
        return i + i1;
    }

}

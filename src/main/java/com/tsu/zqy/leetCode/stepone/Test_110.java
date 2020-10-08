package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

/**
 * @ClassName Test_110
 * @Author Elv1s
 * @Date 2020/10/5 10:10
 * @Description:
 */
public class Test_110 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            // 树的深度一定大于等于0
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            // 当不存在子节点的时候 就返回0
            if (root == null) {
                return 0;
            }
            // 计算左子树深度
            int leftHeight = height(root.left);
            // 计算右子树深度
            int rightHeight = height(root.right);
            // 如果子树存在不平衡, 那么整棵树都不平衡   或者, 两棵子树的高度差大于1
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                // 如果任然是平衡的, 那就深度加一
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
}

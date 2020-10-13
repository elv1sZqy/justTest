package com.tsu.zqy.leetCode.stepFive;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

/**
 * @author zhuQiYun
 * @create 2020/10/12
 * @description :
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_530 {
    /**
     * 因为是二叉搜索树 , 差值最小一定出现在相邻的两个节点之间
     */
    class Solution {
        private int min = Integer.MAX_VALUE;
        int pre = -1;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return min;
            }
           dfs(root);
            return min;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != -1) {
                min = Math.min(min, root.val - pre);
            }
            pre = root.val;
            dfs(root.right);
        }
    }
}

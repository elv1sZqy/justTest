package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

/**
 * @ClassName Test_104
 * @Author Elv1s
 * @Date 2019/7/24 9:54
 * @Description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_104 {

    public int maxDepth(TreeNode root) {
       return root == null ? 0 : 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    /*
    // 递归的方式, 时间超时
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) + 1 : maxDepth(root.right) + 1;
    }
    */
}

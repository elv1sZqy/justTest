package com.tsu.zqy.leetCode;

/**
 * @ClassName Test_112
 * @Author zhuQiYun
 * @Date 2019/8/17 14:45
 * @Description:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_112 {

    public static void main(String[] args){
        System.out.println(new Test_112().hasPathSum(null, 0));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0){
            return false;
        }
        if (root.val == sum && (root.left != null || root.right!= null)){
            return false;
        }
        return dispose(root, sum);
    }

    private boolean dispose(TreeNode root, int sum) {
        // 如果当前节点已经是最后一个节点, sum还不是0,就是没有合适的路径, 返回false
        if (root == null){
            if (sum == 0){
                return true;
            }
            return false;
        }
        // 不为空, 就减去当前的节点的值
        sum -= root.val;
        boolean rightHas = hasPathSum(root.right, sum);
        boolean leftHas = hasPathSum(root.left, sum);
        return rightHas || leftHas;
    }
}

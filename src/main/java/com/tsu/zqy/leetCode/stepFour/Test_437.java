package com.tsu.zqy.leetCode.stepFour;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2019/11/29
 * @description :给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_437 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        System.out.println(new Test_437().pathSum(treeNode, 8));
    }

    private int ref = 0;

    public int pathSum(TreeNode root, int sum) {
        TreeNode current = root;
        while (current!= null){
            fun(current.right,current.val,sum);
            fun(current.left,current.val,sum);
            current= current.right;
        }
       current = root;
        while (current!= null){
            fun(current.right,current.val,sum);
            fun(current.left,current.val,sum);
            current= current.left;
        }

        return ref;
    }

    private void fun(TreeNode root, int currentSum, int sum) {
        if (root==null){
            return;
        }
        currentSum += root.val;
        if (sum == currentSum) {
            ref++;
        }
        fun(root.left, currentSum, sum);
        fun(root.right, currentSum, sum);
    }

}

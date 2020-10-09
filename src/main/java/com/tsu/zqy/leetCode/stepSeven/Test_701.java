package com.tsu.zqy.leetCode.stepSeven;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2020/9/30
 * @description :给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_701 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[4,2,7,1,3]");
        TreeNode treeNode1 = solution.insertIntoBST(treeNode, 5);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
   static class Solution {


        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            // 试试for循环的
            TreeNode currentNode = root;
            while (currentNode != null) {
                boolean isSmallerThanCurrentNodeVal = currentNode.val > val;
                if (isSmallerThanCurrentNodeVal) {
                    TreeNode left = currentNode.left;
                    if (left == null) {
                        TreeNode treeNode = new TreeNode(val);
                        currentNode.left = treeNode;
                        break;
                    }
                    currentNode = left;
                }else {
                    TreeNode right = currentNode.right;
                    if (right == null) {
                        TreeNode treeNode = new TreeNode(val);
                        currentNode.right = treeNode;
                        break;
                    }
                    currentNode = right;
                }
            }

            // 递归的实现
          /*
          // 没判断空的情况
            insert(root, val);*/
            return root;
        }

        private void insert(TreeNode root, int val) {
            int rootVal = root.val;
            boolean isSmallerThanCurrentNodeVal = rootVal > val;
            if (isSmallerThanCurrentNodeVal) {
                if (root.left == null) {
                    TreeNode treeNode = new TreeNode(val);
                    root.left = treeNode;
                    return;
                }
                insert(root.left, val);
            } else {
                if (root.right == null) {
                    TreeNode treeNode = new TreeNode(val);
                    root.right = treeNode;
                    return;
                }
                insert(root.right, val);
            }
        }
    }
}

package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @author zhuQiYun
 * @create 2020/5/13
 * @description :
 */
public class Test_108 {
    public static void main(String[] args) {
        TreeNode treeNode = Test_108.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TreeNodeWrapper.prettyPrintTree(treeNode);
    }

    static int[] arrs;

    public  static TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(arrs[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        arrs = nums;
        return helper(0, nums.length - 1);
    }


    /**
     * 失败作品...
     * │           ┌── 10
     * │       ┌── 9
     * │       │   └── 8
     * │   ┌── 7
     * │   │   └── 6
     * └── 5
     * └── 4
     * │   ┌── 3
     * └── 2
     * └── 1
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int length = nums.length;
        int halfTreeNodeSize = (length - 1) / 2;
        TreeNode root = new TreeNode(nums[halfTreeNodeSize]);
        TreeNode tempNode = new TreeNode(nums[0]);
        for (int i = 1; i < halfTreeNodeSize; i = i + 2) {
            TreeNode leftNode = new TreeNode(nums[i]);
            if (i + 1 < halfTreeNodeSize) {
                TreeNode rightNode = new TreeNode(nums[i + 1]);
                leftNode.left = tempNode;
                leftNode.right = rightNode;
                tempNode = leftNode;
            } else {
                leftNode.left = tempNode;
                tempNode = leftNode;
            }
        }
        root.left = tempNode;
        tempNode = new TreeNode(nums[length - 1]);
        for (int i = length - 2; i > halfTreeNodeSize; i = i - 2) {
            TreeNode rightNode = new TreeNode(nums[i]);
            if (i - 1 > halfTreeNodeSize) {
                TreeNode leftNode = new TreeNode(nums[i - 1]);
                rightNode.left = leftNode;
                rightNode.right = tempNode;
                tempNode = rightNode;
            } else {
                tempNode.right = rightNode;
                tempNode = rightNode;
            }
        }
        root.right = tempNode;
        return root;
    }
}

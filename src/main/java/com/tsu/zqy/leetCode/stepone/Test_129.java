package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/10/29
 * @description :
 */
public class Test_129 {
    private List<String> traces = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }

    private int getSum(TreeNode root, int i) {
        if (null == root) {
            return 0;
        }
        i = i * 10 + root.val;
        if (root.right == null && root.left == null) {
            return i;
        }
        return getSum(root.left, i) + getSum(root.right, i);
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        collectChildNodeValue(root, "");
        int count = 0;
        for (String trace : traces) {
            count += Integer.valueOf(trace);
        }
        return count;
    }

    private void collectChildNodeValue(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += root.val;
            traces.add(s);
            return;
        }
        s += root.val;
        collectChildNodeValue(root.left, s);
        collectChildNodeValue(root.right, s);
    }
}

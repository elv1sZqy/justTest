package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2020/10/27
 * @description :
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int val = root.val;
        result.add(val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}

package com.tsu.zqy.leetCode.steptwo;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

import java.util.*;

/**
 * @author zhuQiYun
 * @create 2019/11/4
 * @description :给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_257 {

    public static void main(String[] args) {
    }

    /**
     * 递归...
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        String path = "" + root.val;
        getBinaryTreePaths(root, set, path);
        List<String> list = new ArrayList<>(set);
        return list;
    }

    private void getBinaryTreePaths(TreeNode root, Set<String> list, String path) {
        if (Objects.isNull(root.left)) {
            if (Objects.isNull(root.right)) {
                list.add(path);
            }
        } else {
            getBinaryTreePaths(root.left, list, path + "->" + root.left.val);
        }
        if (Objects.isNull(root.right)) {
            if (Objects.isNull(root.left)) {
                list.add(path);
            }
        } else {
            getBinaryTreePaths(root.right, list, path + "->" + root.right.val);
        }
    }
}

package com.tsu.zqy.leetCode.steptwo;

import com.tsu.zqy.leetCode.wrapper.TreeNode;

/**
 * @author zhuQiYun
 * @create 2019/10/17
 * @description :
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根节点的值大于两个待查数的值,  说明两个节点都在左边
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        // 根节点的值小于两个待查数的值,  说明两个节点都在右边
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        // 一个大一个小,  根节点就是结果
        else {
            return root;
        }
    }
}

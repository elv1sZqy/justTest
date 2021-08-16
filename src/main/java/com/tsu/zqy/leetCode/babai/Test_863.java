package com.tsu.zqy.leetCode.babai;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2021/7/28
 * @description :
 * <p>
 * <p>
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_863 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode targetNode = new TreeNode(5);
        System.out.println(new Test_863().distanceK(treeNode, targetNode, 2));
    }

    private Integer noWayNode;
    private Map<TreeNode, TreeNode> relationshipMap = null;

    /**
     * 分三步
     * 1. 找出targetNode  (入参已经有了)
     * 2. 从targetNode向下找k距离的节点
     * 3. 从targetNode向上(从targetNode到RootNode为止), 求向上路径中的节点到k-n的值
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        findParentNode(root, target);

        list.addAll(lookingForDown(target, k));
        if (target != null) {
            TreeNode parentNode = findParentNode(root, target);
            noWayNode = target.val;
            list.addAll(distanceK(root, parentNode, k - 1));
        }
        return list;
    }


    private TreeNode findParentNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (root.right != null && root.right.val == target.val) {
            return root;
        }
        if (root.left != null && root.left.val == target.val) {
            return root;
        }
        TreeNode parentNode1 = findParentNode(root.right, target);
        TreeNode parentNode2 = findParentNode(root.left, target);

        return parentNode1 == null ? parentNode2 : parentNode1;
    }

    private List<Integer> lookingForDown(TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if (target == null || (noWayNode != null && target.val == noWayNode)) {
            return list;
        }
        if (k == 0) {
            list.add(target.val);
            return list;
        }
        list.addAll(lookingForDown(target.left, k - 1));
        list.addAll(lookingForDown(target.right, k - 1));
        return list;
    }
}

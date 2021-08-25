package com.tsu.zqy.leetCode.nine;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

/**
 * @ClassName Test_993
 * @Author Elv1s
 * @Date 2021/7/13 16:16
 * @Description: 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @link https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class Test_993 {


    private TreeNode xParentNode = null;
    private TreeNode yParentNode = null;

    private int xDeep = -1;
    private int yDeep = -1;

    public static void main(String[] args){
        Test_993 test_993 = new Test_993();
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[1,2,3,null,4]");
        System.out.println(test_993.isCousins(treeNode, 2, 3));
    }


    /**
     * 深度优先遍历, 记录x, y的深度和父节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        collectData(null, root, x, y, 0);

        if (xDeep != -1 &&
            xDeep == yDeep &&
        xParentNode != yParentNode) {
            return true;
        }
        return false;
    }

    private void collectData(TreeNode parentNode, TreeNode node, int x, int y, int i) {
        if (node == null) return;

        int val = node.val;
        if (val == x) {
            xParentNode = parentNode;
            xDeep = i;
            return;
        }

        if (val == y) {
            yParentNode = parentNode;
            yDeep = i;
            return;
        }
        i++;
        collectData(node , node.left, x, y, i);
        collectData(node, node.right, x, y, i);
    }


}

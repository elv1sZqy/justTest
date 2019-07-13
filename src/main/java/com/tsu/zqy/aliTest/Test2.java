package com.tsu.zqy.aliTest;

/**
 * @ClassName Test2
 * @Author Elv1s
 * @Date 2019/7/3 16:12
 * @Description:  反转二叉树
 */
public class Test2 {

    public static void main(String[] args) {
        //树的根节点
        TreeNode root  = new TreeNode(1);
        //反转之后的树
        TreeNode reRoot  = reverseTree(root);
    }

    /**
     * 反转树
     * @param root 根节点
     * @return  反转之后的根节点
     */
    private static TreeNode reverseTree(TreeNode root) {
        //特殊情况  : root为空   直接返回null
        if (root == null) {
            return null;
        }

        /*利用递归*/
        //反转左边
        root.left = reverseTree(root.getLeft());
        //反转右边
        root.right = reverseTree(root.right);

        //将节点下的左孩子和右孩子互换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //返回当前节点反转之后的结果
        return root;
    }

}

class TreeNode {
    /**
     * 树的值
     */
    int val;
    /**
     * 左孩子
     */
    TreeNode left;
    /**
     * 右孩子
     */
    TreeNode right;

    /**
     *设置值
     * @param x
     */
    public TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

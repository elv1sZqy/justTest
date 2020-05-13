package com.tsu.zqy.leetCode.five;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;
import org.jetbrains.annotations.Nullable;

/**
 * @author zhuQiYun
 * @create 2020/5/7
 * @description :
 */
public class Test_572 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[3,4,5,1,2,null,null,0]");
        TreeNode treeNode2 = TreeNodeWrapper.stringToTreeNode("[4,1,2]");
        System.out.println(isSubtree(treeNode, treeNode2));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        Boolean x = oneThemIsNull(s, t);
        if (x != null){
            return x;
        }
        if (s.val == t.val) {
            boolean b = isSame(s, t);
            if (b) {
                return b;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    @Nullable
    private static Boolean oneThemIsNull(TreeNode s, TreeNode t) {
        if (null == t) {
            return null == s;
        }
        if (null == s) {
            return null == t;
        }
        return null;
    }


    private static boolean isSame(TreeNode node, TreeNode target) {
        if (null == target) {
            return null == node;
        }
        if (null == node) {
            return null == target;
        }
        if (node.val == target.val) {
            return isSame(node.left, target.left) && isSame(node.right, target.right);
        }
        return false;
    }
}

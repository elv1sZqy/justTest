package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.Linked.Node;
import com.tsu.zqy.leetCode.wrapper.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test_107
 * @Author zhuQiYun
 * @Date 2019/8/17 14:03
 * @Description:  给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Test_107 {

    @Test
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        int deep = 0;
        disposeFun(root, deep, list);
        // 倒置
        Collections.reverse(list);
        return list;
    }

    /**
     * 如果节点为null,直接返回;
     * 不为空,
     * @param node
     * @param deep
     * @param list
     */
    private void disposeFun(TreeNode node, int deep, List<List<Integer>> list) {
        if (node == null){
            return;
        }
        else {
            // deep + 1 >list.size  说明又是下一层了
            if (deep + 1 > list.size()){
                list.add(new ArrayList<>());
            }
            list.get(deep).add(node.val);
            disposeFun(node.left, deep + 1, list);
            disposeFun(node.right, deep + 1, list);
        }

    }
}

package com.tsu.zqy.leetCode.stepone;

import com.tsu.zqy.leetCode.wrapper.TreeNode;
import com.tsu.zqy.leetCode.wrapper.TreeNodeWrapper;

import java.util.*;

/**
 * @author zhuQiYun
 * @create 2020/5/13
 * @description :
 */
public class Test_102 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeWrapper.stringToTreeNode("[1,2,3,4,null,null,5]");
        Test_102.levelOrder(treeNode);
    }

    private static List<List<Integer>> result = new ArrayList<>();

    /**
     * 1 ms	39.5 MB
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> oneFloor = new ArrayList<>();
        oneFloor.add(root.val);
        result.add(oneFloor);
        addOtherFloorData(root.left, root.right, 2);
        return result;
    }

    private static void addOtherFloorData(TreeNode left, TreeNode right, int floor) {
        boolean b = result.size() < floor;
        List<Integer> currentFloorResult = b ? new ArrayList<>() : result.get(floor-1);
        if ((null != left || null != right) && b) {
            result.add(currentFloorResult);
        }
        int nextFloor = floor + 1;
        if (null != left) {
            currentFloorResult.add(left.val);
            addOtherFloorData(left.left, left.right, nextFloor);
        }
        if (null != right) {
            currentFloorResult.add(right.val);
            addOtherFloorData(right.left, right.right, nextFloor);
        }

    }


    /**
     * 2 ms	40.2 MB
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> result  = new ArrayList<>();
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        List<Integer> oneFloor = new ArrayList<>();
        oneFloor.add(root.val);
        resultMap.put(1, oneFloor);
        addOtherFloorData2(root.left, root.right, 2,resultMap);
        resultMap.forEach((floor, list) -> result.add(list));
        return result;
    }

    private void addOtherFloorData2(TreeNode left, TreeNode right, int floor, Map<Integer, List<Integer>> resultMap) {
        List<Integer> result = resultMap.get(floor) == null ? new ArrayList<>() : resultMap.get(floor);
        int nextFloor = floor + 1;
        if (null != left) {
            result.add(left.val);
            addOtherFloorData2(left.left, left.right, nextFloor, resultMap);
        }
        if (null != right) {
            result.add(right.val);
            addOtherFloorData2(right.left, right.right, nextFloor, resultMap);
        }
        if (result.size() > 0) {
            resultMap.put(floor,result);
        }
    }
}

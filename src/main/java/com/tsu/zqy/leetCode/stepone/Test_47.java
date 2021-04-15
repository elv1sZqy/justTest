package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Test_46
 * @Author Elv1s
 * @Date 2020/9/20 13:49
 * @Description:
 */
public class Test_47 {
    public static void main(String[] args) {
        Test_47 test_46 = new Test_47();
        System.out.println(test_46.permute(new int[]{1,3, 2}));
    }

    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] used = new boolean[length];

        dfs(new ArrayList<>(), nums, used);
        return new ArrayList<>(ans);
    }

    private void dfs(List<Integer> list, int[] nums, boolean[] used) {
        int length = nums.length;
        if (list.size() == length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    private void dfs2(List<Integer> list, int[] nums, boolean[] used, int deep) {
        int length = nums.length;
        if (deep == length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs2(list, nums, used, ++deep);
            deep = resetStatus2(list, used, deep, i);
        }
    }

    private void resetStatus(List<Integer> list, boolean[] used, int i) {
        used[i] = false;
        list.remove(list.size() - 1);
    }

    private int resetStatus2(List<Integer> list, boolean[] used, int deep, int i) {
        deep -= 1;
        used[i] = false;
        list.remove(list.size() - 1);
        return deep;
    }
}

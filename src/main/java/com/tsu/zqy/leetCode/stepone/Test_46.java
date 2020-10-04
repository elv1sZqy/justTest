package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test_46
 * @Author Elv1s
 * @Date 2020/9/20 13:49
 * @Description:
 */
public class Test_46 {
    public static void main(String[] args) {
        Test_46 test_46 = new Test_46();
        System.out.println(test_46.permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] used = new boolean[length];

        dfs(new ArrayList<>(), nums, used);
        //dfs2(new ArrayList<>(), nums, used, 0);
        return ans;
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
            resetStatus(list, used, i);
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

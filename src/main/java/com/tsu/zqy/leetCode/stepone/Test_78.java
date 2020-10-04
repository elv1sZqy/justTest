package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test_78
 * @Author Elv1s
 * @Date 2020/9/20 10:43
 * @Description:
 */
public class Test_78 {

    public static void main(String[] args) {
        Test_78 test_78 = new Test_78();
        System.out.println(test_78.subsets(new int[]{5, 2, 9}));
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        // 每次都会添加一个空集, 所以remove
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    // 位图解决
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int length = nums.length;
        // 有2的length次方种情况
        int caseCount = 1 << length;
        for (int decimalNumber = 0; decimalNumber < caseCount; ++decimalNumber) {
            List<Integer> t = new ArrayList<Integer>();
            // 将十进制的数转化成二进制表示, 0表示该位不取值,1表示取值
            for (int i = 0; i < length; ++i) {
                int currentIndex = decimalNumber & (1 << i);
                if (currentIndex != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}

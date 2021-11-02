package com.tsu.zqy.leetCode.stepFive;

import com.sun.javaws.progress.PreloaderDelegate;
import org.junit.Test;

import java.util.*;

/**
 * @author zhuQiYun
 * @create 2021/11/1
 * @description :
 */
public class Test_575 {

    @Test
    public void fun() {
        int[] nums = {1, 1};
        System.out.println(distributeCandies(nums));
    }


    public int distributeCandies1(int[] candyType) {
        int length = candyType.length;
        int maxLength = length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            if (!set.contains(i)) {
                set.add(i);
            }
            if (set.size() == maxLength) {
                return maxLength;
            }
        }
        return set.size();
    }

    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int length = candyType.length;
        int count = 1;
        for (int i = 1; i < length && count < length / 2; i++) {
            if (candyType[i] > candyType[i - 1]) {
                count++;
            }
        }
        return count;
    }

}

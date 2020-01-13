package com.tsu.zqy.leetCode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2020/1/13
 * @description :斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Test6 {
    private static Map<Integer, Integer> cache = new HashMap<>();

    static {
        cache.put(1,1);
        cache.put(2,2);
    }

    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n < 2) {
            return n;
        }
        int i = fib(n - 1) + fib(n - 2);
        cache.put(n,i);
        return i;

    }
}

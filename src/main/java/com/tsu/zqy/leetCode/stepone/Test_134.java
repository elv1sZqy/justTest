package com.tsu.zqy.leetCode.stepone;

/**
 * @author zhuQiYun
 * @create 2020/12/29
 * @description :
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_134 {

    public static void main(String[] args) {
        Test_134 test_134 = new Test_134();
        int[] ints = {1,2,3,4,5};
        int[] ints2 = {3, 4, 3};
        System.out.println(test_134.canCompleteCircuit(ints, ints2));
    }

    /**
     * 贪心
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int count = 0;
        int[] rest = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int currGas = gas[i];
            int currCost = cost[i];
            int currRest = currGas - currCost;
            rest[i] = currRest;
            count += currRest;
        }
        // 先计算一遍, 看整体下来剩余的油能不能大于等于0
        if (count < 0) {
            return -1;
        }
        // 因为前面已经判断了, 所以这之后的情况都是可以遍历走一遍的,只是要找到起始点
        // 找到一个最小值 找到最小值意味着 后面的油总量相加大于等于这个最小值, 也就是最小值后面那个站就可以作为起始站
        int min = 0;
        // 记录从第零站开始到达后面每一站时油的剩余量
        int sum = 0;
        // 记录可能成为起始站的坐标
        int startIndex = 0;
        for (int i = 0; i < rest.length; i++) {
            int currRest = rest[i];
            sum += currRest;
            if (sum < min) {
                startIndex = i + 1;
                min = sum;
            }
        }
        return startIndex;
    }

    /**
     * 暴力
     * 局部最优, 本站能加的油大于等于到下一站需要耗费的油
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (canCompleteCircuit(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuit(int startIndex, int[] gas, int[] cost) {
        int length = gas.length;
        int endIndex = getEndIndex(startIndex, length);
        int count = 0;
        for (int i = startIndex; i < gas.length; i++) {
            int costGas = cost[i];
            int addGas = gas[i];
            count += addGas - costGas;
            if (count < 0) {
                return false;
            }
            if (i == endIndex) {
                return true;
            }

            // 成环
            if (i == length - 1) {
                i = -1;
            }
        }
        return true;
    }

    private int getEndIndex(int startIndex, int length) {
        if (startIndex > 0) {
            return startIndex - 1;
        }
        if (startIndex == 0) {
            return length - 1;
        }
        if (length - 1 == startIndex) {
            return 0;
        }
        return 0;
    }
}

package com.tsu.zqy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test_118
 * @Author Elv1s
 * @Date 2019/8/17 20:20
 * @Description:
 *  给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *  在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_118 {
    public static void main(String[] args){
        System.out.println(new Test_118().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0){
            return list;
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        //  第一行一定是1
        list.add(list1);
        if (numRows == 1){
            return list;
        }
        // 第二行一定是 1 1
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list.add(list2);
        if (numRows == 2){
            return list;
        }
        List<Integer> currentList = list2;
        for (int i = 2; i < numRows; i++) {
            // i + 1 > size 说明开始新的一行
            if (i + 1 > list.size()){
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < currentList.size() + 1 ; j++) {
                List<Integer> list3 = list.get(i);
                // 第一个和最后一个永远是1
                if (j == 0){
                    list3.add(1);
                }
                else if (j == currentList.size()){
                    list3.add(1);
                }
                else {
                    list3.add(currentList.get(j - 1) + currentList.get(j));
                }
            }
            currentList = list.get(i);
        }
        return list;
    }
}

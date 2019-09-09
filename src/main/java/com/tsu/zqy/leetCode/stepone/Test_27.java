package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_27
 * @Author Elv1s
 * @Date 2019/6/13 14:47
 * @Description: 27. 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_27 {

    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int length = removeDuplicates(nums,2);
        System.out.println(length);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums, int val) {
        //为空
        if (nums.length == 0){
            return 0;
        }
        //一个指针
        int index = 0 ;

        for (int i = 0; i < nums.length; i++) {
            //和第一个数相等的时候
            while (i <nums.length && val == nums[i]){
                i++;
                if (i >=nums.length){
                    return index;
                }
            }
            //退出循环, 说明不是规定值

            //将不是规定值换到前面的位置
            nums[index] = nums[i];
            index++;
        }

        return index;
    }
}

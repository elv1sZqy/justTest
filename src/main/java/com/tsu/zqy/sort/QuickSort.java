package com.tsu.zqy.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QuickSort
 * @Author Elv1s
 * @Date 2019/5/10 13:43
 * @Description:
 */
public class QuickSort {
    
    public static void main(String[] args){

        //当前时间毫秒值
        long statrTime = System.currentTimeMillis();
        Random random = new Random();
        int[] arr =  new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        /*Quicksort(arr,0, arr.length-1);

        for (int a : arr) {
            System.out.print(a + "  ");
        }

       long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime - statrTime)/1000 + " s" );*/

        //Arrays 中的排序
        long statrTime2 = System.currentTimeMillis();
        Arrays.sort(arr);
        long endTime2 = System.currentTimeMillis();

        System.out.println((endTime2 - statrTime2)/1000 + " s" );

    }

    public  static void Quicksort(int[] arr, int left, int right) {

        if (left >= right){
            return;
        }

        //将数组的最左边确定为基数
        int base = arr[left];
        //指定一个指针,从最右边向左边移,遇到小于基数的则暂停
        int hight = right;
        //指定一个指针,从最左边向右边移动,遇到大于基数的则暂停
        int low = left;

        //只要最右边和最左边的指针指向的不是同一个值
        while (hight != low){

            //上面这句话也可以理解为: 向左移在大于等于基数则不停止(继续左移 )
            while (arr[hight] >= base && hight > low){
                hight--;
            }
            //出了循环意味着向左移动的指针停止了, 找到了比基数小的值

            //现在开始移动左边的指针向右边移动
            //和上边同理
            while (arr[low] <= base && low < hight){
                low++;
            }

            //经过两个while  当前的状态就是两个指针都停止了, 此时交换两个指针所指的数.
            int temp = arr[low];
            arr[low] = arr[hight];
            arr[hight] = temp;

            //继续进行循环即可
        }

        //出循环意味着low == hight
        //此时需要将base和 两个指针(low和hight)共同指的值进行交换
        // 等同于 arr[left] = arr[hight]
        arr[left] = arr[low];
        arr[low] = base;

        //现在已经进行了一次交换,base左边的全小于base,右边全大于base

        //对左边再进行上述方法
        //low 一定要 -1 因为中间是基数, 不要去动他, 所以指针向前移动一位
        Quicksort(arr, left, low-1);

        //同理  对右边也进行递归
        //hight 一定要 +1
        Quicksort(arr, hight + 1, arr.length-1);

    }

}

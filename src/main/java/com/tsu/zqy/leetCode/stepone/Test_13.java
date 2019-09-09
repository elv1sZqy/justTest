package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Test_13
 * @Author Elv1s
 * @Date 2019/6/12 15:50
 * @Description:
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_13 {
    public static void main(String[] args){
        String x = "XXVII";
        int result = solution(x);
        System.out.println(result);
    }

    /**
     * 百度找的条件:
     * 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
     * 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
     * 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
     * 在一个数的上面画一条横线，表示这个数增值 1,000 倍，如
     * @param x
     * @return
     */
    private static int solution(String x) {

        //hashmap 存字符 数字的关系
        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        //转换成字符数组
        char[] chars = x.toCharArray();


        ArrayList<Integer> list = new ArrayList<>();

        /*
           主要根据这个规则写
            V 和X 左边的小数字只能用Ⅰ。
            L 和C 左边的小数字只能用X。
            D 和M 左边的小数字只能用C。*/
        for (int i = 0; i < chars.length; ) {
            switch (chars[i]){
                //如果是I
                case 'I' :
                    //左边是X 或者V 才是 后者减前者
                    if (((i+1) <= chars.length-1) && (chars[i+1] == 'X' || chars[i+1] == 'V')){
                        list.add(map.get(chars[i+1]) - map.get(chars[i]));
                        i = i + 2;
                    }
                    else {
                        list.add(map.get(chars[i]));
                        i++;
                    }
                    break;
                case 'X' :
                    if (((i+1) <= chars.length-1) && (chars[i+1] == 'L' || chars[i+1] == 'C')){
                        list.add(map.get(chars[i+1]) - map.get(chars[i]));
                        i = i + 2;
                    }
                    else {
                        list.add(map.get(chars[i]));
                        i++;
                    }
                    break;
                case 'C' :
                    if (((i+1) <= chars.length-1) && (chars[i+1] == 'D' || chars[i+1] == 'M')){
                        list.add(map.get(chars[i+1]) - map.get(chars[i]));
                        i = i + 2;
                    }
                    else {
                        list.add(map.get(chars[i]));
                        i++;
                    }
                    break;
                default:
                    list.add(map.get(chars[i]));
                    i++;
            }
        }
        //集合中的值相加
        for (int i1 = 0; i1 < list.size(); i1++) {
            result += list.get(i1);
        }

        return result;
    }


}

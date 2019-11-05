package com.tsu.zqy.leetCode.steptwo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuQiYun
 * @create 2019/11/5
 * @description :
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 *
 * 输出: "1A3B"
 *
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 *
 * 输出: "1A1B"
 *
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_299 {
    public static void main(String[] args) {
        new Test_299().getHint("11", "10");
    }

    public String getHint(String secret, String guess) {
        int bullsNum = 0;
        int cowsNum = 0;
        String[] secrets = secret.split("");
        String[] split = guess.split("");
        Map<String, Integer> map = new HashMap<>(split.length);
        //  计算公牛
        for (int i = 0; i < secrets.length; i++) {
            if (secrets[i].equals(split[i])) {
                bullsNum++;
                split[i] = null;
            }
            else {
                if (map.containsKey(secrets[i])) {
                    map.put(secrets[i],map.get(secrets[i]) + 1);
                }
                else {
                    map.put(secrets[i],1);
                }
            }
        }
        for (int i = 0; i < split.length; i++) {
            String key = split[i];
            if (map.containsKey(key)) {
                cowsNum++;
                Integer times = map.get(key);
                if (times.equals(1)) {
                    map.remove(key);
                }
                else {
                    map.put(key, times -1);
                }
            }
        }


        return bullsNum + "A" + cowsNum + "B";
    }
}

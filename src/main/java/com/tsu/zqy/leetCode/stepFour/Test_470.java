package com.tsu.zqy.leetCode.stepFour;

import java.util.Objects;
import java.util.Random;

/**
 * @ClassName Test_470
 * @Author Elv1s
 * @Date 2021/9/5 12:45
 * @Description:
 */
public class Test_470 {
    public static void main(String[] args){
        Test_470 test_470 = new Test_470();
        for (int i = 0; i < 1000; i++) {
            int j = test_470.rand10();
            if (j > 7) {
                System.out.println(j);
            }
        }
    }

    public int rand10() {
        int i = rand7();
        int i1 = Objects.hash(i) % 10 + 1;
        return i1;
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }

}

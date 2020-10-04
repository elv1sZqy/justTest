package com.tsu.zqy.leetCode.stepone;

/**
 * @ClassName Test_22
 * @Author Elv1s
 * @Date 2020/9/20 16:45
 * @Description:
 */
public class Test_22 {
    class Solution {
        public int paintingPlan(int n, int k) {

            if (k == n * n) {
                return 1;
            }

            int ans = 0;
            for (int a = 0; a <= n; a++) {
                for (int b = 0; b <= n; b++) {
                    int sum = a * n + b * n - a * b;
                    if (sum == k) {
                        int x = combination(n, a);
                        int y = combination(n, b);
                        ans += x * y;
                    }
                }
            }

            return ans;
        }

        int combination(int n, int m) {
            int ans = 1;
            for (int i = n; i > m; i--) {
                ans *= i;
            }
            for (int i = n - m; i > 0; i--) {
                ans /= i;
            }
            return ans;
        }
    }
}

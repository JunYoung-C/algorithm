package programmers.lv3.거스름돈;

import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int answer = 0;
        int minMoney = money[0];
        int[] dp = new int[n + 1];
        if (minMoney > n) {
            return 0;
        }

        dp[minMoney] = 1;
        for (int num = minMoney + 1; num <= n; num++) {
            long count = dp[num - minMoney];

            for (int i = 1; i < money.length; i++) {
                if (num % money[i] == 0) {
                    count++;
                }
            }

            dp[num] = (int)(count % 1000000007);
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[n];
    }
}

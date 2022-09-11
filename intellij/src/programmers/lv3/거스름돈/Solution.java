package programmers.lv3.거스름돈;

import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n + 1];
        Arrays.sort(money);

        for (int m : money) {
            if (m <= n) {
                dp[m]++;
            }

            for (int i = m + 1; i <= n; i++) {
                dp[i] = (dp[i - m] + dp[i]) % 1_000_000_007;
            }
        }

        return dp[n];
    }
}

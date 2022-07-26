package programmers.lv2.줄서는방법;

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        for (int len = n; len > 0; len--) {
            int index = (int)((k - 1) / dp[len - 1]);
            answer[n - len] = numbers.remove(index);
            k -= index * dp[len - 1];
        }

        return answer;
    }
}
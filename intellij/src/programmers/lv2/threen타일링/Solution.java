package programmers.lv2.threen타일링;

class Solution {
    public int solution(int n) {
        if (n == 2) {
            return 3;
        } else if (n % 2 == 1) {
            return 0;
        }

        long[] dp = new long[n + 1];
        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i <= n; i+=2) {
            long sum = 2 + dp[i - 2] * 3;
            for (int j = i - 4; j >= 2; j-= 2) {
                sum += dp[j] * 2;
            }
            dp[i] = sum % 1000000007;
        }
        return (int)dp[n];
    }
}
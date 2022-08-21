package programmers.lv3.거스름돈;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int moneyLen = money.length;
        int[][] dp = new int[moneyLen + 1][n + 1];
        for (int i = 1; i <= moneyLen; i++) {
            dp[i][0] = 1;
        }

        for (int row = 1; row <= moneyLen; row++) {
            for (int j = 1; j <= n; j++) {
                if (j - money[row - 1] < 0) {
                    dp[row][j] = dp[row - 1][j];
                } else {
                    dp[row][j] = (dp[row][j - money[row - 1]] + dp[row - 1][j]) % 1000000007;
                }
            }
        }

        return dp[moneyLen][n];
    }
}

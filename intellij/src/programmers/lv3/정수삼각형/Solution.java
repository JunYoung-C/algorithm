package programmers.lv3.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        for (int row = 0; row < len - 1; row++) {
            for(int col = 0; col <= row; col++) {
                dp[row + 1][col] = Math.max(dp[row + 1][col], dp[row][col] + triangle[row + 1][col]);
                dp[row + 1][col + 1] = Math.max(dp[row + 1][col + 1], dp[row][col] + triangle[row + 1][col + 1]);
            }
        }

        for (int col = 0; col < len; col++) {
            answer = Math.max(answer, dp[len - 1][col]);
        }

        return answer;
    }
}

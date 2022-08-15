package programmers.lv3.최적의행렬곱셈;

class Solution {
    int[][] matrixArr;
    long[][] dp;
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int len = matrix_sizes.length;
        dp = new long[len][len];
        matrixArr = matrix_sizes;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (r != c) {
                    dp[r][c] = Long.MAX_VALUE;
                }
            }
        }
        return (int)getMatrixMul(0, len - 1);
    }

    private long getMatrixMul(int lt, int rt) {
        if (dp[lt][rt] != Long.MAX_VALUE) {
            return dp[lt][rt];
        }

        for (int i = lt; i < rt; i++) {
            long mul = matrixArr[lt][0] * matrixArr[i][1] * matrixArr[rt][1];
            dp[lt][rt] = Math.min(dp[lt][rt],
                    getMatrixMul(lt, i) + getMatrixMul(i + 1, rt) + mul);
        }

        return dp[lt][rt];
    }
}

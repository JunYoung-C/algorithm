package programmers.kakao.lv3.파괴되지않은건물;

class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int width = board[0].length;
        int height = board.length;
        int[][] dp = new int[height + 1][width + 1];
        final int ATTACK = 1, HEAL = 2;

        for (int[] skill : skills) {
            int type = skill[0]; // 1 : 공격, 2 : 회복
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            if (type == ATTACK) {
                dp[r1][c1] -= degree;
                dp[r1][c2 + 1] += degree;
                dp[r2 + 1][c1] += degree;
                dp[r2 + 1][c2 + 1] -= degree;
            } else {
                dp[r1][c1] += degree;
                dp[r1][c2 + 1] -= degree;
                dp[r2 + 1][c1] -= degree;
                dp[r2 + 1][c2 + 1] += degree;
            }
        }

        // 열이 증가하는 방향으로 dp값 변경
        for (int r = 0; r < height; r++) {
            for (int c = 1; c < width; c++) {
                dp[r][c] += dp[r][c - 1];
            }
        }

        // 행이 증가하는 방향으로 dp값 변경
        for (int c = 0; c < width; c++) {
            for (int r = 1; r < height; r++) {
                dp[r][c] += dp[r - 1][c];
            }
        }

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (dp[r][c] + board[r][c] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}